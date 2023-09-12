package com.example.lovecalculator.model

import android.content.SharedPreferences
import com.example.lovecalculator.App.Companion.SHOWED_KEY
import javax.inject.Inject

class Pref @Inject constructor(private val preferences: SharedPreferences) {

    fun isOnBoardingShowed(): Boolean {
        return preferences.getBoolean(SHOWED_KEY, false)
    }

    fun onBoardingShowed() {
        preferences.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    fun onBoardingShow() {
        preferences.edit().putBoolean(SHOWED_KEY, false).apply()
    }

}