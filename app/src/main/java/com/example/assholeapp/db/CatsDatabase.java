package com.example.assholeapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CatDb.class}, version = 1)
public abstract class CatsDatabase extends RoomDatabase {
    public abstract CatDao catDao();

    public static CatsDatabase create(Context context) {
        return Room
                .databaseBuilder(context, CatsDatabase.class, "Cats-DB")
                .allowMainThreadQueries()
                .build();
    }
}