package com.example.rolo.ramennagikiosk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class orderAdaptor extends RecyclerView.Adapter<orderHolder> {

    private ArrayList<orderData> order_Data;
    private Context activity;

    public orderAdaptor(Context activity){
        this.activity = activity;
        this.order_Data = new ArrayList<>();


        //these values will be retrieved by firebase
        //placeholder values

//        strings.add("Gyoza");
//        strings.add("Original King - Butao");
//        orderData order = new orderData(strings, "order1");
//        this.order_Data.add(order);

        FirebaseDatabase fd;
        fd = FirebaseDatabase.getInstance();
        final OrderIDSingleton singleton = OrderIDSingleton.getInstance();
        DatabaseReference dr = fd.getReference();

        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    ArrayList<String> strings = new ArrayList<>();
                    for (DataSnapshot child: postSnapshot.getChildren()){
                        if (!child.getValue().toString().equals("false") && !child.getValue().toString().equals("true")){
                            strings.add(child.getValue().toString());
                        } else if (child.getValue().toString().equals("true")){
                            order_Data.add(new orderData(strings, postSnapshot.getKey().toString()));
                        }
                    }
                }
                notifyChange();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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

    public void notifyChange(){
        notifyDataSetChanged();
    }
}
