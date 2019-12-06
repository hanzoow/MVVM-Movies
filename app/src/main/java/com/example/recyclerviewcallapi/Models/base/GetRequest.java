package com.example.recyclerviewcallapi.Models.base;

import android.os.AsyncTask;

import java.io.IOException;

public class GetRequest extends AsyncTask<Void, Void, String> {
    private FetchDataSuccessListener listener;
    private BaseRequest baseRequest = new BaseRequest();
    private String url;
    private Exception exception;

    public GetRequest(String url, FetchDataSuccessListener listener) {
        this.listener = listener;
        this.url = url;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            return baseRequest.request(url);
        } catch (IOException e) {
            this.exception = e;
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (exception != null) {
            listener.onFail(exception);
        }else {
            listener.onSuccess(result);
        }
    }

    public interface FetchDataSuccessListener {
        void onSuccess(String result);

        void onFail(Exception error);
    }
}