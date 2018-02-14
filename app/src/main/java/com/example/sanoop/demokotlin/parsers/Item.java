package com.example.sanoop.demokotlin.parsers;

/**
 * Created by C149306 on 14-02-2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("forecast")
    @Expose
    private List<Forecast> forecast = null;

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

}
