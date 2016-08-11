package com.example.scout.legoquest.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.scout.legoquest.R;
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

public class ThemeActivity extends AppCompatActivity {
    private String query;
    private String type;
    ArrayList<Set> sets = new ArrayList<>();
    @Bind(R.id.themeText) TextView mThemeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        query = intent.getStringExtra("query");

        mThemeText.setText(query);

        type = "sets";

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
                sets = legoService.getSets(response);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("CUBONE", "sets: " + sets);
//                        Collections.sort(descriptions);
//                        Log.d("CUBONE", "sorted: " + descriptions);
//                        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, descriptions);
//                        mThemeListView.setAdapter(adapter);
//
//                        mThemeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                            @Override
//                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                String theme = ((TextView)view).getText().toString();
//
//                                Intent intent = new Intent(MainActivity.this, ThemeActivity.class);
//                                intent.putExtra("query", theme);
//                                startActivity(intent);
//                            }
//                        });

                    }
                });
            }
        });
    }
}
