package com.example.recyclerviewcallapi.views.Adapter.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcallapi.Models.Movies;
import com.example.recyclerviewcallapi.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class TestViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivPicture;
    private TextView tvTitle,tvId;
    private Movies movies = new Movies();
    public TestViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvId = itemView.findViewById(R.id.tvId);
        ivPicture = itemView.findViewById(R.id.ivPictures);
    }

    public void bind(Movies movie) {
        tvTitle.setText(movie.getImgTitle());
        tvId.setText(movie.getId());
        Picasso.get().load(movie.getImgUrl()).into(ivPicture);
    }
}
