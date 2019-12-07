package com.example.recyclerviewcallapi.Models.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

class BaseRequest {
    public String request(String link) throws IOException {
        StringBuffer result = new StringBuffer();


        URL url = new URL(link);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        InputStream inputStream = httpsURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;
        do {
            line = bufferedReader.readLine();
            result.append(line);
        } while (line != null);

        return result.toString();
      //  throw new IOException("ERROR");
    }
}
