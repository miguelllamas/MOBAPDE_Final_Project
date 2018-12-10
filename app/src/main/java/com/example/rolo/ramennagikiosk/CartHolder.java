package com.example.rolo.ramennagikiosk;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class CartHolder extends RecyclerView.ViewHolder {

    private TextView itemname;
    private Button remove;
    private String key;

    public CartHolder(@NonNull View itemView) {
        super(itemView);
        itemname = itemView.findViewById(R.id.cartItem);
        remove = itemView.findViewById(R.id.removeButton);
    }

    public void setText(String itemName, float price){
        itemname.setText(itemName + " - " + price);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setButton(){
        remove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase fd = FirebaseDatabase.getInstance();
                OrderIDSingleton si = OrderIDSingleton.getInstance();

                DatabaseReference dr = fd.getReference(si.getCurrOrderID());
                dr.child(key).removeValue();
            }
        });
    }
}
