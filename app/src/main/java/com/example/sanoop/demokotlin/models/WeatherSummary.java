package com.example.sanoop.demokotlin.models;

import java.util.List;

/**
 * Created by C149306 on 15-02-2018.
 */

public class WeatherSummary {

    private String title;
    private String sunrise;
    private String sunset;

    private List<ForecastModel> forecastModels;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public List<ForecastModel> getForecastModels() {
        return forecastModels;
    }

    public void setForecastModels(List<ForecastModel> forecastModels) {
        this.forecastModels = forecastModels;
    }
}
