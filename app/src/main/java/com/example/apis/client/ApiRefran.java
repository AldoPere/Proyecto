package com.example.apis.client;


import com.example.apis.service.UsoRefranes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRefran {
    public static final String URL_BASE = "https://my-json-server.typicode.com/AldoPere/Refranes/";
    private static Retrofit retrofit;

    public  static UsoRefranes getApiService(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(UsoRefranes.class);
    }
}
