package com.example.rolo.ramennagikiosk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CartAdaptor extends RecyclerView.Adapter<CartHolder>{

    private ArrayList<CartData> cartData;
    private Context activity;
    public CartAdaptor(Context activity){
        this.activity = activity;
        cartData = new ArrayList<>();

        //place holder data
        //fix later depending on how to query from firebase
        cartData.add(new CartData("Gyoza", 220));
        cartData.add(new CartData("Red King", 410));
    }
    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.cart_item, viewGroup, false);
        CartHolder holder = new CartHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder cartHolder, int i) {
        cartHolder.setText(cartData.get(i).getItem(), cartData.get(i).getPrice());
        cartHolder.setButton();
    }

    @Override
    public int getItemCount() {
        return cartData.size();
    }

    public void notifyChange(){
        notifyDataSetChanged();
    }
}
