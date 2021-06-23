package com.example.dolartotl.data;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static Retrofit retrofit = null;
    // http://api.currencylayer.com/live?access_key=2dd02c99f50f5d8fdf6e9e9e1184670d&format=1
    private static String BASE_URL = "http://api.currencylayer.com/";
    private final String API_KEY = "2dd02c99f50f5d8fdf6e9e9e1184670d";
    private final Integer connectionTimeout= 10000;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
            return retrofit;

        }
        return retrofit;
    }
}
