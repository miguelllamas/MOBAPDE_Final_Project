package com.example.rolo.ramennagikiosk;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menuHolder extends RecyclerView.ViewHolder {

    private TextView itemName;
    private TextView itemPrice;
    private String desc;
    private String name;
    private float price;
    private Button viewMore;

    public menuHolder(@NonNull View itemView) {
        super(itemView);

        itemName = itemView.findViewById(R.id.itemName);
        itemPrice = itemView.findViewById(R.id.price);
        viewMore = itemView.findViewById(R.id.detailsButton);
    }

    public void setName(String name) {
        this.name = name;
        itemName.setText(name);
    }
    public void setPrice(float price) {
        this.price = price;
        itemPrice.setText(price+" PHP");
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public void setButton(){
        viewMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), details.class);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                intent.putExtra("desc", desc);
                v.getContext().startActivity(intent);
            }
        });
    }
}
