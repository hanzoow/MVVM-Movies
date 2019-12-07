package com.example.recyclerviewcallapi.views;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcallapi.Models.Movies;
import com.example.recyclerviewcallapi.Models.base.DataObserver;
import com.example.recyclerviewcallapi.R;
import com.example.recyclerviewcallapi.viewmodels.MovieVM;
import com.example.recyclerviewcallapi.views.Adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    TestAdapter myAdapter;
    public static ImageView img;
    public static TextView tvData;
    private MovieVM movieVM;
  //  private RecyclerView recyclerView;

    private DataObserver.OnDataChange<Exception> errorObserver = new DataObserver.OnDataChange<Exception>() {
        @Override
        public void onMovieChange(Exception e) {
            //Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private DataObserver.OnDataChange<List<Movies>> moviesObserver = new DataObserver.OnDataChange<List<Movies>>() {
        @Override
        public void onMovieChange(List<Movies> movies) {
            //Toast.makeText(MainActivity.this, movies.size(), Toast.LENGTH_SHORT).show();
            // day adapter
            Log.e("set","setted");
//            myAdapter = new TestAdapter(movies);
//          recyclerView.setAdapter(myAdapter);
//         layoutManager =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//         recyclerView.setLayoutManager(layoutManager);
            setRecycleView(movies);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieVM = new MovieVM();
        recyclerView = findViewById(R.id.rvTest);
        movieVM.moviesObserver.addDataChangeObserver(moviesObserver);
        movieVM.errorObserver.addDataChangeObserver(errorObserver);
        movieVM.getMovie();

//        myAdapter = new TestAdapter(movie,this);
//        recyclerView.setAdapter(myAdapter);
//        layoutManager =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(layoutManager);
//        FetchData fetchData = new FetchData(new FetchData.FetchDataSuccessListener() {
//            @Override
//            public void onSuccess(List<Movies> movies) {
//                Log.e("MOVIE", String.valueOf(movies.size()));
//            }
//        });
//        fetchData.execute();
//        Log.d("t","wdqd");
//        String img_url = tvData.getText().toString();
//        Log.d("img",img_url);
//        Picasso.get().load(img_url).into(img);
//        recyclerView = findViewById(R.id.rvTest);
//
//        myAdapter = new TestAdapter(img_url,this);
//        recyclerView.setAdapter(myAdapter);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        movieVM.moviesObserver.removeDataChangeObserver(moviesObserver);
        movieVM.moviesObserver.removeDataChangeObserver(errorObserver);
    }


    protected void setRecycleView(List<Movies> movie){
        myAdapter = new TestAdapter(movie);
        //recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }
//
//    @Override
//    public void onMovieChange(List<Movies> movies) {
//        Log.e("MOVIE", String.valueOf(movies.size()));
//    }

//    @Override
//    public void onMovieChange(List<Movies> movies)<> {
//        Log.e("MOVIE", String.valueOf(movies.size()));
//    }
}
