package com.example.scout.legoquest.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.scout.legoquest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ThemeActivity extends AppCompatActivity {
    private String query;
    @Bind(R.id.themeText) TextView mThemeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        query = intent.getStringExtra("query");

        mThemeText.setText(query);


    }
}
