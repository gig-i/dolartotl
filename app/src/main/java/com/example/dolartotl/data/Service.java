package com.example.dolartotl.data;

import com.example.dolartotl.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("live?access_key=2dd02c99f50f5d8fdf6e9e9e1184670d&format=1")
    Call<Model> getRepo();
}
