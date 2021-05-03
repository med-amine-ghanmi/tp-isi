package com.example.travauxpratiques1.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    String baseURL = "https://newsapi.org/v2/";



    public ApiService getRetrofitClient(){

        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);

    }

}
