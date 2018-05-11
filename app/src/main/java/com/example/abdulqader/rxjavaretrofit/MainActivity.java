package com.example.abdulqader.rxjavaretrofit;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abdulqader.rxjavaretrofit.Adapter.PostAdapter;
import com.example.abdulqader.rxjavaretrofit.data.DatabaseImp;
import com.example.abdulqader.rxjavaretrofit.model.post;
import com.example.abdulqader.rxjavaretrofit.retrofit.Api;
import com.example.abdulqader.rxjavaretrofit.retrofit.client;

import java.util.List;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Api api;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable=new CompositeDisposable();

    private static final String DATABASENAME="POST_DATABASE";
    private DatabaseImp databaseImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit= client.getinstance();
        api=retrofit.create(Api.class);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseImp= Room.databaseBuilder(
                getApplicationContext(),
                DatabaseImp.class,
                DATABASENAME
        ).allowMainThreadQueries().fallbackToDestructiveMigration().
                build();
      //  FetchData();
        showdatafromdatabase();



    }

    private void FetchData() {
    compositeDisposable.add(api.getPosts()
    .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Consumer<List<post>>(){

        @Override
        public void accept(List<post> posts) throws Exception {
            displaydata(posts);
        }
    }));
    }

    private void displaydata(List<post> posts) {

        databaseImp.access().InsertMultiplePosts(posts);
        PostAdapter adapter= new PostAdapter(this,posts);
        recyclerView.setAdapter(adapter);
    }

    private void showdatafromdatabase(){
       List<post>posts= databaseImp.access().getAllpost();
        PostAdapter adapter= new PostAdapter(this,posts);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
