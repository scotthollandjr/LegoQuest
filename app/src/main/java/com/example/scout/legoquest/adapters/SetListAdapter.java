package com.example.scout.legoquest.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.scout.legoquest.R;
import com.example.scout.legoquest.models.Set;
import com.example.scout.legoquest.ui.SetDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SetListAdapter extends RecyclerView.Adapter<SetListAdapter.SetViewHolder> {
    private ArrayList<Set> mSets = new ArrayList<>();
    private Context mContext;
    private Set mSet;

    public SetListAdapter(Context context, ArrayList<Set> sets) {
        mContext = context;
        mSets = sets;
    }

    @Override
    public SetListAdapter.SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_list_item, parent, false);
        SetViewHolder viewHolder = new SetViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SetListAdapter.SetViewHolder holder, int position) {
        holder.bindSet(mSets.get(position));
    }

    @Override
    public int getItemCount() {
        return mSets.size();
    }

    public class SetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.listImage) ImageView mListImage;
        @Bind(R.id.descrText) TextView mDescrText;
        @Bind(R.id.yearText) TextView mYearText;
        @Bind(R.id.piecesText) TextView mPiecesText;

        private Context mContext;

        public SetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            //Set mSet = mSets.get(itemPosition);
            Intent intent = new Intent(mContext, SetDetailActivity.class);
            intent.putExtra("position", itemPosition + "");
            intent.putExtra("sets", Parcels.wrap(mSets));
            mContext.startActivity(intent);
        }

        public void bindSet(Set set) {
            Glide.with(mContext)
                    .load(set.getImg_tn())
                    .into(mListImage);
            mDescrText.setText(set.getDescr());
            mPiecesText.setText(set.getPieces() + " pieces");
            mYearText.setText(set.getYear() + "");
        }
    }
}