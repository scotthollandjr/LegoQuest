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
    @Bind(R.id.themeText) TextView mThemeView;

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
        mPiecesView.setText(mSet.getPieces() + "");
        mYearView.setText(mSet.getYear() + "");
        mThemeView.setText(mSet.getTheme1());

        return view;
    }

}
