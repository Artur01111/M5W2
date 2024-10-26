package com.example.m5w2.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m5w2.OnLesson.LoveApiService
import com.example.m5w2.OnLesson.PercentageResponse
import com.example.m5w2.di.room.LoveDao
import com.example.m5w2.di.room.LoveEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: LoveApiService,
    private val loveDao: LoveDao
) : ViewModel() {

    private val _historyData = MutableLiveData<List<LoveEntity>>()
    val historyData: LiveData<List<LoveEntity>> get() = _historyData

    fun fetchPercentageAndSave(firstName: String, secondName: String) {
        val apiKey = "YOUR_API_KEY"
        val apiHost = "love-calculator.p.rapidapi.com"

        apiService.fetchPercentage(firstName, secondName, apiKey, apiHost)
            .enqueue(object : Callback<PercentageResponse> {
                override fun onResponse(call: Call<PercentageResponse>, response: Response<PercentageResponse>) {
                    if (response.isSuccessful) {
                        response.body()?.let { percentageResponse ->
                            val loveEntity = LoveEntity(
                                firstName = percentageResponse.fname,
                                secondName = percentageResponse.sname,
                                percentage = percentageResponse.percentage,
                                result = percentageResponse.result
                            )

                            // Сохранение данных в Room
                            viewModelScope.launch {
                                loveDao.insertHistory(loveEntity)
                                _historyData.postValue(loveDao.getDescendingHistory()) // Обновление LiveData
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<PercentageResponse>, t: Throwable) {
                }
            })
    }
}