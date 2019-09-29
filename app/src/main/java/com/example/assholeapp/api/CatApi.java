package com.example.assholeapp.api;

import com.example.assholeapp.db.CatDb;
import com.google.gson.annotations.SerializedName;

public class CatApi {
    @SerializedName("url")
    public String imageUrl;

    public CatDb toCarDb(){
        return new CatDb(this.imageUrl);
    }
}

