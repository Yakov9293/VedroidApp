package com.example.assholeapp.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cat")
public class CatDb {
    @PrimaryKey
    public long id;
    public String imageUrl;
    private static long idCount;

    public CatDb(String imageUrl){
        this.id = idCount;
        this.imageUrl = imageUrl;
        idCount++;
    }
}
