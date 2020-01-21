package com.example.sectionedrecyclerview.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectionedrecyclerview.DataLoader.HomeDataLoader;
import com.example.sectionedrecyclerview.R;
import com.example.sectionedrecyclerview.SectionRecyclerWithFooter.HomeNewsSection;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class HomeFragment extends Fragment implements HomeNewsSection.HomeSectionListener{
    private RecyclerView mRecyclerView;
    private Context mContext;
    private SectionedRecyclerViewAdapter mSectionedAdapter;
    public static final String URL = "https://jsonplaceholder.typicode.com/posts";
    public static final String Country = "Country";
    public static final String Sec = "Android Books";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        mContext = getContext();

        mSectionedAdapter = new SectionedRecyclerViewAdapter();
        mSectionedAdapter.addSection(new HomeNewsSection(Country, HomeDataLoader.getHomeDataSectionA(mContext, URL, mSectionedAdapter), this, mContext));
        mSectionedAdapter.addSection(new HomeNewsSection(Sec, HomeDataLoader.getHomeDataSectionA(mContext, URL, mSectionedAdapter), this, mContext));
        mRecyclerView = view.findViewById(R.id.home_frag_recycler_view_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mSectionedAdapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onItemViewClick(@NonNull String title, @NonNull int adapterPosition) {
        Toast.makeText(mContext, "Click@ "+adapterPosition, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFooterViewClick(String sectionTitle) {

    }
}
