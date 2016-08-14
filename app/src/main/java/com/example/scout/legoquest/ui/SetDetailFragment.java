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
//        Bundle args = new Bundle();
//        //Log.d("CUBONE", "fraggy setDetailFrag: " + set.getDescr());
//        args.putParcelable("set", Parcels.wrap(set));
//        setDetailFragment.setArguments(args);
        return setDetailFragment;
    }

    public SetDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Bundle bundle = getArguments();
////        String set_id = bundle.getString("set_id");
////        String descr = bundle.getString("descr");
////        int year = Integer.parseInt(bundle.getString("year"));
////        int pieces = Integer.parseInt(bundle.getString("pieces"));
////        String theme1 = bundle.getString("theme1");
////        String theme2 = bundle.getString("theme2");
////        String theme3 = bundle.getString("theme3");
////        String url = bundle.getString("url");
////        String img_tn = bundle.getString("img_tn");
////        String img_big = bundle.getString("img_big");

        mSet = getArguments().getParcelable("mSet");

        //mSet = new Set(set_id, descr, year, pieces, theme1, theme2, theme3, url, img_tn, img_big);

        Log.d("CUBONE", "fraggy onCreate: " + mSet.getDescr());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_detail, container, false);
        ButterKnife.bind(this, view);

//        Glide.with(this)
//                .load(mSet.getImg_big())
//                .into(mImageView);
//        mDescrView.setText(mSet.getDescr());
        //mPiecesView.setText(mSet.getPieces() + "");
        //mYearView.setText(mSet.getYear() + "");
        //mThemeView.setText(mSet.getTheme1());

        return view;
    }

}
