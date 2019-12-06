package com.example.recyclerviewcallapi.views;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewcallapi.Models.Movies;
import com.example.recyclerviewcallapi.Models.base.DataObserver;
import com.example.recyclerviewcallapi.R;
import com.example.recyclerviewcallapi.viewmodels.MovieVM;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //    private RecyclerView.LayoutManager layoutManager;
//    private RecyclerView recyclerView;
//    TestAdapter myAdapter;
    public static ImageView img;
    public static TextView tvData;
    private MovieVM movieVM;

    private DataObserver.OnDataChange<Exception> errorObserver = new DataObserver.OnDataChange<Exception>() {
        @Override
        public void onMovieChange(Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private DataObserver.OnDataChange<List<Movies>> moviesObserver = new DataObserver.OnDataChange<List<Movies>>() {
        @Override
        public void onMovieChange(List<Movies> movies) {
            Toast.makeText(MainActivity.this, movies.size(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.ivTest);
        tvData = findViewById(R.id.tvTest);
        movieVM = new MovieVM();

        movieVM.moviesObserver.addDataChangeObserver(moviesObserver);
        movieVM.errorObserver.addDataChangeObserver(errorObserver);
        movieVM.getMovie();


//
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
