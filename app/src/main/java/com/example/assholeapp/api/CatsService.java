package com.example.assholeapp.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatsService {
    private static CatsService instance;
    private static final String BASE_URL = "https://api.thecatapi.com/";
    private Retrofit retrofit;

    private CatsService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient
                        .Builder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .addInterceptor(interceptor)
                        .build())
                .build();
    }

    public static CatsService getInstance() {
        if (instance == null) {
            instance = new CatsService();
        }
        return instance;
    }

    public CatsApi getCatsApi() {
        return retrofit.create(CatsApi.class);
    }
}
