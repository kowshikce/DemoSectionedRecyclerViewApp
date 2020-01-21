package com.example.sectionedrecyclerview.SectionRecyclerWithFooter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectionedrecyclerview.R;

public class HomeItemViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    View rootView;
    TextView tvTitle;
    TextView tvDescription;

    public HomeItemViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.home_frag_recycler_item_imgItem_id);
        rootView = itemView;
        tvTitle = itemView.findViewById(R.id.home_frag_recycler_item_tv_title_id);
        tvDescription = itemView.findViewById(R.id.home_frag_recycler_item_tv_description_id);
    }
}
