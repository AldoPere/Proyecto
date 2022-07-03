package com.example.apis.service;

import com.example.apis.entity.Message;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UsoRefranes {
    @GET("Refranes/{id}")
    Call<Message> getMessageId1(@Path("id") int id);
}