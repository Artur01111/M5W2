package com.example.m5w2.fragment.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.m5w2.OnLesson.PercentageResponse
import com.example.m5w2.OnLesson.RetrofitService
import com.example.m5w2.R
import com.example.m5w2.databinding.FragmentRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {

    private val binding by lazy { FragmentRegisterBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }
    private fun onClickListener() {
        fun EditText.getString() = this.text.toString()
        binding.calculate.setOnClickListener {
            RetrofitService.api.fetchPercentage(
                firstName = binding.firstName.getString(),
                secondName = binding.secondName.getString(),
                host = "love-calculator.p.rapidapi.com",
                key = "13db8c0c9fmsh0e8b65404615b3ap1035a5jsn85bfe5faab5c"
            ).enqueue(object : Callback<PercentageResponse> {
                override fun onResponse(
                    call: Call<PercentageResponse>,
                    response: Response<PercentageResponse>
                ) {
                    if (response.body() != null && response.isSuccessful) {
                        val percentageResponse = response.body()!!
                        val bundle = Bundle().apply {
                            putString("firstName", percentageResponse.fname)
                            putString("secondName", percentageResponse.sname)
                            putString("percentage", percentageResponse.percentage)
                            putString("result", percentageResponse.result)
                        }
                        Log.d("Navigation", "Navigating to result fragment with data: $percentageResponse")
                        findNavController().navigate(R.id.action_registerFragment_to_resultFragment, bundle)
                    } else{
                        Log.d("API Response", "Response failed: ${response.code()} - ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<PercentageResponse>, t: Throwable) {
                    Log.e("Tag", "onViewCreated: code: ${t.localizedMessage}")
                }
            })
        }
    }
}