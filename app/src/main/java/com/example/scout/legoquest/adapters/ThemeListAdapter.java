package com.example.scout.legoquest.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.scout.legoquest.R;
import com.example.scout.legoquest.models.Theme;
import com.example.scout.legoquest.ui.ThemeActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by scout on 8/17/16.
 */
public class ThemeListAdapter extends RecyclerView.Adapter<ThemeListAdapter.ThemeViewHolder> {
    private ArrayList<Theme> mThemes = new ArrayList<>();
    private Context mContext;
    private Theme mTheme;

    public ThemeListAdapter(Context context, ArrayList<Theme> themes) {
        mContext = context;
        mThemes = themes;
    }

    @Override
    public ThemeListAdapter.ThemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theme_list_item, parent, false);
        ThemeViewHolder viewHolder = new ThemeViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ThemeListAdapter.ThemeViewHolder holder, int position) {
        holder.bindTheme(mThemes.get(position));
    }

    @Override
    public int getItemCount() {
        return mThemes.size();
    }

    public class ThemeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.themeText) TextView mThemeText;

        private Context mContext;

        public ThemeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Theme theme = mThemes.get(itemPosition);
            String queryDescr = theme.getDescr();
            Intent intent = new Intent(mContext, ThemeActivity.class);
            intent.putExtra("query", queryDescr);
            mContext.startActivity(intent);
        }

        public void bindTheme(Theme theme) {
            mThemeText.setText(theme.getDescr());
        }
    }
}
