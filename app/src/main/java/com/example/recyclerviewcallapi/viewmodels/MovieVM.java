package com.example.recyclerviewcallapi.viewmodels;

import android.util.Log;

import com.example.recyclerviewcallapi.Models.Movies;
import com.example.recyclerviewcallapi.Models.base.DataObserver;
import com.example.recyclerviewcallapi.Models.interactor.MovieInteractor;

import java.util.List;

public class MovieVM {
    private MovieInteractor movieInteractor;
    public DataObserver moviesObserver = new DataObserver<List<Movies>>();
    public DataObserver errorObserver = new DataObserver<Exception>();

    public MovieVM() {
        movieInteractor = new MovieInteractor();
    }

    public void getMovie() {
        movieInteractor.getMovie(new MovieInteractor.GetMovieListener() {
            @Override
            public void onGetMovieSuccess(List<Movies> movies) {
                moviesObserver.postData(movies);
            }

            @Override
            public void onGetMovieFail(Exception e) {
                errorObserver.postData(e);
            }
        });
    }
}
