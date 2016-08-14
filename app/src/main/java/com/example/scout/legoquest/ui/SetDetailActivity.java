package com.example.scout.legoquest.ui;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.scout.legoquest.R;
import com.example.scout.legoquest.models.Set;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class SetDetailActivity extends AppCompatActivity {
    private Set mSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_detail);
        ButterKnife.bind(this);

        mSet = Parcels.unwrap(getIntent().getParcelableExtra("set"));
        //Log.d("CUBONE", "within setDetaActiv " + mSet.getDescr());

        SetDetailFragment setDetailFragment = new SetDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("set", Parcels.wrap(mSet));
        setDetailFragment.setArguments(bundle);
    }
}
