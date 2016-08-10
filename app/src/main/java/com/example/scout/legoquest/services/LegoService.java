package com.example.scout.legoquest.services;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.LauncherApps;
import android.os.Handler;
import android.os.IBinder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class LegoService extends Service {
    private static final String THEME_URL = "https://rebrickable.com/api/get_themes?key=";
    private static final String SETS_URL = "https://rebrickable.com/api/search?key=";
    private static final String DETAIL_URL = "https://rebrickable.com/api/get_set?key=";
    private static final String THEME_2 = "&format=json";
    private static final String SETS_2 = "&format=json&type=S&query=";
    private static final String DETAIL_2 = "&format=json&set_id=";
    private static final String API_KEY = "xxxxxxx";
    public static String url;

    public LegoService() {
    }

    public static void findLegos(String type, String query, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        if (type == "theme") {
            url = THEME_URL + API_KEY + THEME_2;
        } else if (type == "sets") {
            url = SETS_URL + API_KEY + SETS_2 + query;
        } else if (type == "detail") {
            url = DETAIL_URL + API_KEY + DETAIL_2 + query;
        }

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }




    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
