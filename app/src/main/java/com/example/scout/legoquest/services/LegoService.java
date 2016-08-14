package com.example.scout.legoquest.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.scout.legoquest.models.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LegoService extends Service {
    private static final String THEME_URL = "https://rebrickable.com/api/get_themes?key=";
    private static final String SETS_URL = "https://rebrickable.com/api/search?key=";
    private static final String DETAIL_URL = "https://rebrickable.com/api/get_set?key=";
    private static final String THEME_2 = "&format=json";
    private static final String SETS_2 = "&format=json&type=S&query=";
    private static final String DETAIL_2 = "&format=json&set_id=";
    private static final String API_KEY = "m2nvy9nFl9";
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
        }

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<String> getThemes(Response response) {
        ArrayList<String> themeDesc = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject resultsJSON = new JSONObject(jsonData);
                JSONArray themesJSON = resultsJSON.getJSONArray("themes");

                for (int i = 0; i < themesJSON.length(); i++) {
                    JSONObject itemJSON = themesJSON.getJSONObject(i);
                    String description = itemJSON.getString("descr");

                    if (themeDesc.indexOf(description) == -1) {
                        themeDesc.add(description);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return themeDesc;
    }

    public ArrayList<Set> getSets(Response response) {
        ArrayList<Set> sets = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject resultsJSON = new JSONObject(jsonData);
                JSONArray setsJSON = resultsJSON.getJSONArray("results");

                for (int i = 0; i < setsJSON.length(); i++) {
                    JSONObject itemJSON = setsJSON.getJSONObject(i);
                    String set_id = itemJSON.getString("set_id");
                    String descr = itemJSON.getString("descr");
                    int year = Integer.parseInt(itemJSON.getString("year"));
                    int pieces = Integer.parseInt(itemJSON.getString("pieces"));
                    String theme1 = itemJSON.getString("theme1");
                    String theme2 = itemJSON.getString("theme2");
                    String theme3 = itemJSON.getString("theme3");
                    String url = itemJSON.getString("url");
                    String img_tn = itemJSON.getString("img_tn");
                    String img_big = itemJSON.getString("img_big");

                    Set newSet = new Set(set_id, descr, year, pieces, theme1, theme2, theme3, url, img_tn, img_big);
                    sets.add(newSet);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sets;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
