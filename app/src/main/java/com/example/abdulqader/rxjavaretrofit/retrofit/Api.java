package com.example.abdulqader.rxjavaretrofit.retrofit;

import com.example.abdulqader.rxjavaretrofit.model.post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("posts")
    Observable<List<post>> getPosts();
}
