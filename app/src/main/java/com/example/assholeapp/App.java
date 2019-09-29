package com.example.assholeapp;

import android.app.Application;

import androidx.room.Room;

import com.example.assholeapp.db.CatsDatabase;

public class App extends Application {

    public static App instance;

    private CatsDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = CatsDatabase.create(this);
    }

    public static App getInstance() {
        return instance;
    }

    public CatsDatabase getDatabase() {
        return database;
    }
}