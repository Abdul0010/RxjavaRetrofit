package com.example.abdulqader.rxjavaretrofit.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.abdulqader.rxjavaretrofit.model.post;

import java.util.List;

@Dao
public interface DatabaseInterface {
    @Insert
    void InsertOnlySinglePost(post post);

    @Insert
    void InsertMultiplePosts(List<post>posts);
    @Update
    void updatePost(post post);
    @Delete
    void deletePost(post post);

    @Query("Select * from post")
    List<post>getAllpost();




}
