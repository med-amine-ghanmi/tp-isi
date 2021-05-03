package com.example.travauxpratiques1.remote;


import com.example.travauxpratiques1.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {


    @GET("everything?q=Apple&from=2021-05-03&sortBy=popularity&apiKey=87795d43e3a3445e82bd7d1a3ad217f6")
    Call<NewsResponse> getNews();


}
