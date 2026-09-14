package com.eshreef.help.Viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eshreef.help.Interface.ItemclickLisnter;
import com.eshreef.help.R;

public class Desisviewhold extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ItemclickLisnter itemclickLisnter;

    public TextView Desis_name;
    public   ImageView Desis_image;
    public Desisviewhold(@NonNull View itemView) {
        super(itemView);
        Desis_name = itemView.findViewById(R.id.Desis_name);
        Desis_image = itemView.findViewById(R.id.Desis_image);
        itemView.setOnClickListener(this);

    }
    public void setItemclickLisnter(ItemclickLisnter itemclickLisnter) {
        this.itemclickLisnter = itemclickLisnter;

    }



    @Override
    public void onClick(View v) {
        itemclickLisnter.onClick(v,getAdapterPosition(),false);

    }
}
