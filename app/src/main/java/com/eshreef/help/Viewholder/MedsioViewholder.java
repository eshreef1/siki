package com.eshreef.help.Viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eshreef.help.Interface.ItemclickLisnter;
import com.eshreef.help.R;

public class MedsioViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ItemclickLisnter itemclickLisnter;

  public  TextView medison_name;
 public   ImageView medison_image;

    public MedsioViewholder(@NonNull View itemView) {
        super(itemView);
        medison_name = itemView.findViewById(R.id.medion_name);
        medison_image = itemView.findViewById(R.id.medion_image);
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
