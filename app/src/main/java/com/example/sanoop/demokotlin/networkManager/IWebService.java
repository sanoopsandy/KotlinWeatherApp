package com.example.sanoop.demokotlin.networkManager;

import com.example.sanoop.demokotlin.parsers.WeatherReportResponseParser;
import com.example.sanoop.demokotlin.utils.Constant;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by C149306 on 14-02-2018.
 */

public interface IWebService {

    String getWeatherReportURL = "v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22bangalore%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.HOST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(getWeatherReportURL)
    Call<WeatherReportResponseParser> getForecastData();

}
