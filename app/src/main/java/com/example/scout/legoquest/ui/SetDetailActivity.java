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
        //Log.d("CUBONE", "within setDetaActiv " + mSet.getDescr());

        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));

        adapterViewPager = new SetPagerAdadpter(getSupportFragmentManager(), mSets);
        viewPager.setAdapter(adapterViewPager);
        viewPager.setCurrentItem(startingPosition);
//        SetDetailFragment setDetailFragment = new SetDetailFragment();
//
//

//        Bundle bundle = new Bundle();
//        bundle.putString("set_id", mSet.getSet_id());
//        bundle.putString("descr", mSet.getDescr());
//        bundle.putString("year", mSet.getYear() + "");
//        bundle.putString("pieces", mSet.getPieces() + "");
//        bundle.putString("theme1", mSet.getTheme1());
//        bundle.putString("theme2", mSet.getTheme2());
//        bundle.putString("theme3", mSet.getTheme3());
//        bundle.putString("url", mSet.getUrl());
//        bundle.putString("img_tn", mSet.getImg_tn());
//        bundle.putString("img_big", mSet.getImg_big());
//
//        FragmentManager manager = getFragmentManager();
//        Fragment fragment = manager.findFragmentById(R.id.detailFragment);
//
//        Bundle bundle1 = new Bundle();
//        bundle.putParcelable("mSet", Parcels.wrap(mSet));
//        fragment.setArguments(bundle1);
//
//        manager.beginTransaction().replace(R.id.detailFragment, fragment);
    }
}
