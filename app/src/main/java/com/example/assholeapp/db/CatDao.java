package com.example.assholeapp.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CatDao {

    @Query("SELECT * FROM cat")
    List<CatDb> all();

    @Insert
    void insert(List<CatDb> cats);
}
