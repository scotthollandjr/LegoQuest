package com.example.scout.legoquest.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.scout.legoquest.models.Set;
import com.example.scout.legoquest.ui.SetDetailActivity;
import com.example.scout.legoquest.ui.SetDetailFragment;

import java.util.ArrayList;


public class SetPagerAdadpter extends FragmentPagerAdapter {
    private ArrayList<Set> mSets;

    public SetPagerAdadpter(FragmentManager fm, ArrayList<Set> sets) {
        super(fm);
        mSets = sets;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("CuBonE", "setpageradapt: " + mSets.get(position).getDescr());
        return SetDetailFragment.newInstance(mSets.get(position));
    }

    @Override
    public int getCount() {
        return mSets.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSets.get(position).getDescr();
    }
}
