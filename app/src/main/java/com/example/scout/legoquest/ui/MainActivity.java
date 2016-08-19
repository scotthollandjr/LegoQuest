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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.scout.legoquest.R;
import com.example.scout.legoquest.adapters.SetListAdapter;
import com.example.scout.legoquest.adapters.ThemeListAdapter;
import com.example.scout.legoquest.models.Set;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Theme> themes = new ArrayList<>();
    private ThemeListAdapter mThemeAdapter;
    ArrayList<Set> sets = new ArrayList<>();
    @Bind(R.id.themeRecyclerView) RecyclerView mThemeRecyclerView;
    @Bind(R.id.searchButton) ImageButton mSearchButton;
    @Bind(R.id.searchEditText) EditText mSearchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String type = "theme";
        String query = "query";

        getLegos(type, query);

        setTitle("Welcome to LegoQuest!");

        mSearchButton.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        if (view == mSearchButton) {
            String query = mSearchEditText.getText().toString();

            Intent intent = new Intent(MainActivity.this, ThemeActivity.class);
            intent.putExtra("query", query);
            this.startActivity(intent);
        }
    }
}
