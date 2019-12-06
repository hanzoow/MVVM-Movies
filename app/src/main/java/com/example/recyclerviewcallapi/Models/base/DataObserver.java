package com.example.recyclerviewcallapi.Models.base;

import java.util.ArrayList;
import java.util.List;

public class DataObserver<T> {
    private List<OnDataChange> listObserver = new ArrayList<>();

    public interface OnDataChange<T> {
        void onMovieChange(T movies);
    }

    public void postData(T data) {
        for (OnDataChange observer : listObserver) {
            observer.onMovieChange(data);
        }
    }

    public void addDataChangeObserver(OnDataChange listener) {
        listObserver.add(listener);
    }

    public void removeDataChangeObserver(OnDataChange listener) {
        listObserver.remove(listener);
    }
}
