package com.example.recyclerviewcallapi.Models;

import android.os.AsyncTask;

import com.example.recyclerviewcallapi.Models.Movies;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class FetchData extends AsyncTask<Void,Void,List<Movies>> {

    private String data ="";
    private String dataParsed = "";
    private String singleParsed ="";
    private String[] dataResult = {};
    private List<Movies> movies = new ArrayList<>();
    private FetchDataSuccessListener listener;

    public FetchData(FetchDataSuccessListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<Movies> doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/r8d8s");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line!=null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for (int i = 0; i <JA.length() ; i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                Movies movie = new Movies();
                movie.setId(JO.getString("id"));
                movie.setImgTitle(JO.getString("image_title"));
                movie.setImgUrl(JO.getString("img_url"));

                movies.add(movie);

//                singleParsed = JO.getString("img_url") ;
//                dataParsed  = dataParsed + singleParsed;
//                dataResult[i] += dataParsed;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movies;
    }

//    @Override
//    protected void onPostExecute(Movies aVoid) {
//        super.onPostExecute(aVoid);
//        Picasso.get().load(singleParsed).into(MainActivity.img);
//    }


    @Override
    protected void onPostExecute(List<Movies> movies) {
        super.onPostExecute(movies);
        listener.onSuccess(movies);
    }

    public interface FetchDataSuccessListener{
        void onSuccess(List<Movies> movies);
    }
}
