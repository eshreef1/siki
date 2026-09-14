package com.eshreef.help.Viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eshreef.help.Interface.ItemclickLisnter;
import com.eshreef.help.R;

public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener  {
    private ItemclickLisnter itemclickLisnter;
    public TextView name;
    public ImageView images;
    public Viewholder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.menu_name);
        images = itemView.findViewById(R.id.image_menu);
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