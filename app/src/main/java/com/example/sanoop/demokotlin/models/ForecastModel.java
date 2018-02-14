package com.example.sanoop.demokotlin.models;

/**
 * Created by C149306 on 14-02-2018.
 */

public class ForecastModel {

    private String date;
    private String lowTemp;
    private String highTemp;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }
}
