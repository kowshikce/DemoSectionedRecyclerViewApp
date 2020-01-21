package com.example.sectionedrecyclerview.SectionRecyclerWithFooter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectionedrecyclerview.R;

public class HomeFooterViewHolder extends RecyclerView.ViewHolder{

    final View rootView;
    final TextView footer;

    public HomeFooterViewHolder(@NonNull View itemView) {
        super(itemView);

        rootView = itemView;
        footer = itemView.findViewById(R.id.home_frag_recycler_footer_tvSeeMore_id);
    }
}
