package com.example.abdulqader.rxjavaretrofit.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.abdulqader.rxjavaretrofit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.title) TextView title;
    @BindView(R.id.content)TextView body;
    @BindView(R.id.author)TextView auther;


    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
