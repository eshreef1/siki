package com.eshreef.help.Viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eshreef.help.Interface.ItemclickLisnter;
import com.eshreef.help.R;

public class HomeViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ItemclickLisnter itemclickLisnter;
     public TextView difnaeion_name;
    public ImageView imageView;
    public HomeViewholder(@NonNull View itemView) {


        super(itemView);
        difnaeion_name = itemView.findViewById(R.id.difnaion_name);
        imageView = itemView.findViewById(R.id.difnaion_image);
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
