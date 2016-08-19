package com.example.scout.legoquest.ui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.scout.legoquest.R;
import com.example.scout.legoquest.adapters.SetListAdapter;
import com.example.scout.legoquest.models.Set;
import com.example.scout.legoquest.services.LegoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ThemeActivity extends AppCompatActivity implements View.OnClickListener {
    private String query;
    private String type;
    private SetListAdapter mSetAdapter;
    ArrayList<Set> sets = new ArrayList<>();
    @Bind(R.id.setRecyclerView) RecyclerView mSetRecyclerView;
    @Bind(R.id.pieceTextView) TextView pieceButton;
    @Bind(R.id.yearTextView) TextView yearButton;
    @Bind(R.id.alphaTextView) TextView alphaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        query = intent.getStringExtra("query");

        type = "sets";

        getLegos(type, query);

        setTitle(query);
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
                sets = legoService.getSets(response);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSetAdapter = new SetListAdapter(getApplicationContext(), sets);
                        mSetRecyclerView.setAdapter(mSetAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ThemeActivity.this);
                        mSetRecyclerView.setLayoutManager(layoutManager);
                        mSetRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == yearButton) {

        }
        if (view == pieceButton) {

        }
        if (view == alphaButton) {

        }
    }
}
