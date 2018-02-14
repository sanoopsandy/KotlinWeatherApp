package com.example.sanoop.demokotlin.viewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

import com.example.sanoop.demokotlin.models.WeatherSummary
import com.example.sanoop.demokotlin.networkManager.NetworkDataManager

/**
 * Created by C149306 on 15-02-2018.
 */

class ForecastViewModel(application: Application) : AndroidViewModel(application) {

    private val weatherSummaryLiveData: LiveData<WeatherSummary>

    init {
        val networkDataManager = NetworkDataManager()
        weatherSummaryLiveData = networkDataManager.getForecastData()
    }

    /*
    * Expose livedata to view
    * */
    public fun getWeatherSummary(): LiveData<WeatherSummary> {
        return weatherSummaryLiveData
    }
}
