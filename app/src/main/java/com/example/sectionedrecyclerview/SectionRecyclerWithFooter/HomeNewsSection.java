package com.example.sectionedrecyclerview.SectionRecyclerWithFooter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectionedrecyclerview.DataLoader.HomePreodicReset;
import com.example.sectionedrecyclerview.ModelData.HomeModel;
import com.example.sectionedrecyclerview.R;

import java.util.ArrayList;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;

public class HomeNewsSection extends Section{

    private String Title;
    private ArrayList<HomeModel> mDataSet;
    private HomeSectionListener listener;
    private Context mContext;

    public HomeNewsSection(@NonNull String mTitle, @NonNull ArrayList<HomeModel> data, @NonNull HomeSectionListener mListener, @NonNull Context context){
        super(SectionParameters.builder().itemResourceId(R.layout.home_frag_recycler_ex1_item)
        .headerResourceId(R.layout.home_frag_recycler_ex1_header).footerResourceId(R.layout.home_frag_recycler_ex1_footer).build());

        this.Title = mTitle;
        this.mDataSet = data;
        this.listener = mListener;
        this.mContext = context;
    }


    @Override
    public int getContentItemsTotal() {
        return mDataSet.size();
    }


    //This is for getting the header view
    //..........HEADERVIEW...............


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HomeHeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        final HomeHeaderViewHolder homeHeaderViewHolder = (HomeHeaderViewHolder) holder;
        homeHeaderViewHolder.sectionTitle.setText(Title);
    }

    //For getting the Home ItemView
    //>>>>>>>>>>>>>>>ITEMVIEW................
    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new HomeItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        final HomeModel cData = mDataSet.get(i);
        final HomeItemViewHolder homeItemViewHolder = (HomeItemViewHolder) viewHolder;

        homeItemViewHolder.tvTitle.setText(cData.getTitle());
        homeItemViewHolder.tvDescription.setText(cData.getBody());
        homeItemViewHolder.imageView.setImageResource(HomePreodicReset.getImageid(mContext));
        homeItemViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemViewClick(Title, homeItemViewHolder.getAdapterPosition());
            }
        });
    }

    //This is for getting the footer view
    //...................FOOOTERVIEW......................
    @Override
    public RecyclerView.ViewHolder getFooterViewHolder(View view) {
        return new HomeFooterViewHolder(view);
    }

    @Override
    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder) {
        final HomeFooterViewHolder homeFooterViewHolder = (HomeFooterViewHolder) holder;
        homeFooterViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFooterViewClick(Title);
            }
        });
    }





    public interface HomeSectionListener{
        void onItemViewClick(@NonNull String title, @NonNull final int adapterPosition);
        void onFooterViewClick(String sectionTitle);
    }
}
