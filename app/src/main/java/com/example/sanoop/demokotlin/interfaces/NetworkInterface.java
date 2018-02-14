package com.example.sanoop.demokotlin.interfaces;

import com.example.sanoop.demokotlin.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by C149306 on 14-02-2018.
 */

public interface NetworkInterface {

    String getAtmLocations = "banking/icicibank/BranchAtmLocator";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.HOST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
