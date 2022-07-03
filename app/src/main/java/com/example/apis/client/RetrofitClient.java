package com.example.apis.client;

import com.example.apis.service.RetrofitApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String URL_BASE = "https://my-json-server.typicode.com/AldoPere/PuercamenteEnamorado/";
    private static Retrofit retrofit;

    public  static RetrofitApiService getApiService(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitApiService.class);
    }
}
