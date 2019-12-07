package com.example.recyclerviewcallapi.Models.interactor;

import com.example.recyclerviewcallapi.Models.Movies;
import com.example.recyclerviewcallapi.Models.base.GetRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieInteractor {
    private GetRequest getRequest;

    public MovieInteractor() {
    }

    public void getMovie(final GetMovieListener listener) {
        getRequest = new GetRequest("https://api.myjson.com/bins/r8d8s", new GetRequest.FetchDataSuccessListener() {
            @Override
            public void onSuccess(String result) {
                try {
                    List<Movies> movies = new ArrayList<>();

                    JSONArray JA = null;
                    JA = new JSONArray(result);
                    for (int i = 0; i < JA.length(); i++) {
                        JSONObject JO = (JSONObject) JA.get(i);
                        Movies movie = new Movies();
                        movie.setId(JO.getString("id"));
                        movie.setImgTitle(JO.getString("image_title"));
                        movie.setImgUrl(JO.getString("img_url"));
                        movies.add(movie);
                    }

                    listener.onGetMovieSuccess(movies);
                } catch (JSONException e) {
                    listener.onGetMovieFail(e);
                }
            }

            @Override
            public void onFail(Exception error) {
                listener.onGetMovieFail(error);
            }
        });

        getRequest.execute();
    }

    public interface GetMovieListener {
        void onGetMovieSuccess(List<Movies> movies);

        void onGetMovieFail(Exception e);
    }
}
