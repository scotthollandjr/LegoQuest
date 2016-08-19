package com.example.scout.legoquest.ui;


import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.scout.legoquest.R;
import com.example.scout.legoquest.models.Set;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SetDetailFragment extends Fragment {
    @Bind(R.id.imageView) ImageView mImageView;
    @Bind(R.id.descrText) TextView mDescrView;
    @Bind(R.id.piecesText) TextView mPiecesView;
    @Bind(R.id.yearText) TextView mYearView;
    @Bind(R.id.themeText1) TextView mThemeView1;
    @Bind(R.id.themeText2) TextView mThemeView2;
    @Bind(R.id.themeText3) TextView mThemeView3;
    @Bind(R.id.urlText) TextView mUrlText;
    @Bind(R.id.ebayText) TextView mEbayText;

    private Set mSet;

    public static SetDetailFragment newInstance(Set set) {
        SetDetailFragment setDetailFragment = new SetDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("set", Parcels.wrap(set));
        setDetailFragment.setArguments(args);
        return setDetailFragment;
    }

    public SetDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSet = Parcels.unwrap(getArguments().getParcelable("set"));


        //mUrlText.setOnClickListener(this);
        //mEbayText.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_detail, container, false);
        ButterKnife.bind(this, view);

        Glide.with(this)
                .load(mSet.getImg_big())
                .into(mImageView);
        mDescrView.setText(mSet.getDescr());
        mPiecesView.setText("Pieces: " + mSet.getPieces());
        mYearView.setText("Released: " + mSet.getYear());
        mThemeView1.setText(mSet.getTheme1());
        if (mSet.getTheme2().equals("null")) {
            mThemeView2.setText("N/A");
        } else {
            mThemeView2.setText(mSet.getTheme2());
        }
        if (mSet.getTheme3().equals("null")) {
            mThemeView3.setText("N/A");
        } else {
            mThemeView3.setText(mSet.getTheme3());
        }
//        mUrlText.setText(mSet.getUrl());
//        mEbayText.setText("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=Lego+" + mSet.getDescr());
        return view;
    }

}
