package com.example.abdulqader.rxjavaretrofit.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.abdulqader.rxjavaretrofit.model.post;

@Database(entities = {post.class}, version = 2,exportSchema = false)
public abstract class DatabaseImp extends RoomDatabase {
    public abstract DatabaseInterface access();
}
