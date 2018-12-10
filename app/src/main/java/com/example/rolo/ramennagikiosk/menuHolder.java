package com.example.rolo.ramennagikiosk;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class menuHolder extends RecyclerView.ViewHolder {

    private TextView itemName;
    private TextView itemPrice;
    private String desc;
    private ImageView itemImage;
    private String name;
    private float price;
    private int image;
    private Button viewMore;

    public menuHolder(@NonNull View itemView) {
        super(itemView);

        itemName = itemView.findViewById(R.id.itemName);
        itemPrice = itemView.findViewById(R.id.price);
        itemImage = itemView.findViewById(R.id.itemImage);
        viewMore = itemView.findViewById(R.id.detailsButton);
    }

    public void setName(String name) {
        this.name = name;
        itemName.setText(name);
    }

    public void setPrice(float price) {
        this.price = price;
        DecimalFormat df2 = new DecimalFormat("0.00");
        itemPrice.setText("PHP " + df2.format(price));
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage(int image) {
        this.image = image;
        itemImage.setImageResource(image);
    }

    public void setButton() {
        viewMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), details.class);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                intent.putExtra("desc", desc);
                intent.putExtra("image", image);
                v.getContext().startActivity(intent);
            }
        });
    }
}
