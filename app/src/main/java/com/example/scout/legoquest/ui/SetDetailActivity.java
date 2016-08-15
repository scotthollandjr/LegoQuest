package com.example.scout.legoquest.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.scout.legoquest.R;
import com.example.scout.legoquest.adapters.SetPagerAdadpter;
import com.example.scout.legoquest.models.Set;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SetDetailActivity extends FragmentActivity {
    @Bind(R.id.viewPager) ViewPager viewPager;
    private Set mSet;
    ArrayList<Set> mSets = new ArrayList<>();
    private SetPagerAdadpter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_detail);
        ButterKnife.bind(this);

        mSets = Parcels.unwrap(getIntent().getParcelableExtra("sets"));

        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));

        adapterViewPager = new SetPagerAdadpter(getSupportFragmentManager(), mSets);
        viewPager.setAdapter(adapterViewPager);
        viewPager.setCurrentItem(startingPosition);
    }
}
