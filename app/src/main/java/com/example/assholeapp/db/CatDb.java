package com.example.assholeapp.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cat")
public class CatDb {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String imageUrl;
}
