package com.example.abdulqader.rxjavaretrofit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abdulqader.rxjavaretrofit.R;
import com.example.abdulqader.rxjavaretrofit.model.post;

import java.util.List;

public class PostAdapter  extends RecyclerView.Adapter<PostViewHolder>{

    public PostAdapter(Context context, List<post> postList) {
        this.context = context;
        this.postList = postList;
    }

    Context context;
    List<post>postList;
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.title.setText(String.valueOf(postList.get(position).getTitle()));
        holder.body.setText(new StringBuilder(postList.get(position)
                .body.substring(0,20)).toString());
        holder.auther.setText(String.valueOf(postList.get(position).getUserId()));

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
