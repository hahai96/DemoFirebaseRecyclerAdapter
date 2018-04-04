package com.example.ha_hai.demofirebaserecycleradapter.ViewHolder;

import android.animation.Animator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ha_hai.demofirebaserecycleradapter.R;

/**
 * Created by ha_hai on 3/28/2018.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder {

    public TextView txtName, txtPrice;
    public ImageView imgHinhAnh;

    public FoodViewHolder(View itemView) {
        super(itemView);

        txtName = itemView.findViewById(R.id.txtName);
        txtPrice = itemView.findViewById(R.id.txtPrice);
        imgHinhAnh = itemView.findViewById(R.id.imgHinhAnh);
    }


}
