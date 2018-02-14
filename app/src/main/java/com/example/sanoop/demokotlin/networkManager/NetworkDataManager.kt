package com.example.sanoop.demokotlin.networkManager

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.sanoop.demokotlin.models.ForecastModel
import com.example.sanoop.demokotlin.models.WeatherSummary
import com.example.sanoop.demokotlin.parsers.WeatherReportResponseParser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


/**
 * Created by C149306 on 14-02-2018.
 */

class NetworkDataManager {

    private val iWebService: IWebService? = IWebService.retrofit.create(IWebService::class.java)

    public fun getForecastData(): LiveData<WeatherSummary> {
        val data = MutableLiveData<WeatherSummary>()
        iWebService!!.forecastData.enqueue(object : Callback<WeatherReportResponseParser> {
            override fun onResponse(call: Call<WeatherReportResponseParser>, response: Response<WeatherReportResponseParser>) {
                val responseParser = response.body()
                val forecastModels = ArrayList<ForecastModel>()
                val weatherSummary = WeatherSummary()
                val sunrise = responseParser!!.query.results.channel.astronomy.sunrise
                val sunset = responseParser.query.results.channel.astronomy.sunset
                val title = responseParser.query.results.channel.title
                weatherSummary.sunrise = sunrise
                weatherSummary.sunset = sunset
                weatherSummary.title = title
                val responseForecasts = responseParser.query.results.channel.item.forecast
                for (responseForecast in responseForecasts) {
                    val forecast = ForecastModel()
                    forecast.date = responseForecast.date
                    forecast.highTemp = responseForecast.high
                    forecast.lowTemp = responseForecast.low
                    forecastModels.add(forecast)
                }
                weatherSummary.forecastModels = forecastModels
                data.value = weatherSummary
            }

            override fun onFailure(call: Call<WeatherReportResponseParser>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return data
    }
}
