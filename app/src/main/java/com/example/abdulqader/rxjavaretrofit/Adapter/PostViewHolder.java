package com.example.abdulqader.rxjavaretrofit.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.abdulqader.rxjavaretrofit.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView title,body,auther;
    public PostViewHolder(View itemView) {
        super(itemView);
        title=(TextView)itemView.findViewById(R.id.title);
        body=(TextView)itemView.findViewById(R.id.content);
        auther=(TextView)itemView.findViewById(R.id.author);
    }
}
