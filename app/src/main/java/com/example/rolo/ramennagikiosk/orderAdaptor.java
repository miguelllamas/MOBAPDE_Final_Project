package com.example.rolo.ramennagikiosk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class orderAdaptor extends RecyclerView.Adapter<orderHolder> {

    ArrayList<orderData> order_Data;
    Context activity;

    public orderAdaptor(Context activity){
        this.activity = activity;
        this.order_Data = new ArrayList<>();

        //placeholder values
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Gyoza");
        strings.add("Original King - Butao");
        orderData order = new orderData(strings, "order1");
        this.order_Data.add(order);

    }


    @NonNull
    @Override
    public orderHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.order_item, viewGroup, false);
        orderHolder holder = new orderHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull orderHolder order_Holder, int i) {
        order_Holder.setOrderNumber(order_Data.get(i).getOrderNumber());
        order_Holder.setOrdersList(order_Data.get(i).getOrders());
        order_Holder.setButton();
    }

    @Override
    public int getItemCount() {
        return this.order_Data.size();
    }
}
