package com.example.m5w2.view_model

import androidx.lifecycle.ViewModel
import com.example.m5w2.OnLesson.LoveApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var apiService: LoveApiService
) : ViewModel() {

}