package com.example.recyclerviewcallapi.views.Adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcallapi.Models.Movies;
import com.example.recyclerviewcallapi.R;
import com.squareup.picasso.Picasso;

public class TestViewHolder extends RecyclerView.ViewHolder {
    private ImageView img;
    private Movies movies = new Movies();
    public TestViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.ivTest);
    }

    public void bind(Movies movie) {
        Picasso.get().load(movies.getImgUrl()).into(img);
    }
}
