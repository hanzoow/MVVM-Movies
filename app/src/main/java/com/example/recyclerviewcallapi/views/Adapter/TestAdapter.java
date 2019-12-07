package com.example.recyclerviewcallapi.views.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcallapi.Models.Movies;
import com.example.recyclerviewcallapi.R;
import com.example.recyclerviewcallapi.views.Adapter.ViewHolder.TestViewHolder;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestViewHolder> {

    private String img_url;
    private Context context;
    private List<Movies> movies;

    public TestAdapter(List<Movies> movies){
     //   this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.test,parent,false);
        return new TestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


}
