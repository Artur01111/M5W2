package com.example.m5w2.utils

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) { var isOnBoardShown: Boolean
    get() = sharedPreferences.getBoolean("onboarding_complete", false)
    set(value) = sharedPreferences.edit().putBoolean("onboarding_complete", value).apply()
}