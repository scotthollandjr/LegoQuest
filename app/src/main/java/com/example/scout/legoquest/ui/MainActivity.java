package com.example.scout.legoquest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.scout.legoquest.R;
import com.example.scout.legoquest.services.LegoService;

import java.io.IOException;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

            }
        });
    }
}
