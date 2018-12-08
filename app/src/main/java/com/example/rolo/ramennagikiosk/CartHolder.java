package com.example.rolo.ramennagikiosk;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CartHolder extends RecyclerView.ViewHolder {

    private TextView itemname;
    private Button remove;

    public CartHolder(@NonNull View itemView) {
        super(itemView);
        itemname = itemView.findViewById(R.id.cartItem);
        remove = itemView.findViewById(R.id.removeButton);
    }

    public void setText(String itemName, float price){
        itemname.setText(itemName + " - " + price);
    }

    public void setButton(){
        remove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
