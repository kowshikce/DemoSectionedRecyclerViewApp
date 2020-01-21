package com.example.sectionedrecyclerview.SectionRecyclerWithFooter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectionedrecyclerview.R;

public class HomeHeaderViewHolder extends RecyclerView.ViewHolder{

    final TextView sectionTitle;

    public HomeHeaderViewHolder(@NonNull View itemView) {
        super(itemView);

        sectionTitle = itemView.findViewById(R.id.home_frag_recycler_header_tv_title_id);
    }
}
