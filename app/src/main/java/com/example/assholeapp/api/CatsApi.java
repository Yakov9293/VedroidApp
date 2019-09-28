package com.example.assholeapp.api;

import com.example.assholeapp.Cat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CatsApi {
    @GET("/v1/images/search")
    Call<List<Cat>> cats(
            @Header("x-api-key") String header,
            @Query("limit") Integer limit,
            @Query("page") Integer page,
            @Query("order") String order
    );
}
