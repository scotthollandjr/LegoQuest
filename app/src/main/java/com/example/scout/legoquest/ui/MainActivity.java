package com.example.scout.legoquest.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.scout.legoquest.R;
import com.example.scout.legoquest.adapters.ThemeListAdapter;
import com.example.scout.legoquest.models.Theme;
import com.example.scout.legoquest.services.LegoService;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> descriptions = new ArrayList<>();
    ArrayList<Theme> themes = new ArrayList<>();
    private ThemeListAdapter mThemeAdapter;
    @Bind(R.id.themeRecyclerView) RecyclerView mThemeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String type = "theme";
        String query = "query";

        getLegos(type, query);
    }

    public void getLegos(String type, String query) {
        final LegoService legoService = new LegoService();

        legoService.findLegos(type, query, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                themes = legoService.getThemes(response);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mThemeAdapter = new ThemeListAdapter(getApplicationContext(), themes);
                        mThemeRecyclerView.setAdapter(mThemeAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        mThemeRecyclerView.setLayoutManager(layoutManager);
                        mThemeRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
