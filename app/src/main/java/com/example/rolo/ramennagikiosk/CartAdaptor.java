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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CartAdaptor extends RecyclerView.Adapter<CartHolder>{

    private ArrayList<CartData> cartData;
    private Context activity;
    public CartAdaptor(Context activity){
        this.activity = activity;
        cartData = new ArrayList<>();

        //place holder data
        //fix later depending on how to query from firebase
        FirebaseDatabase fd;
        fd = FirebaseDatabase.getInstance();
        final OrderIDSingleton singleton = OrderIDSingleton.getInstance();
        DatabaseReference dr = fd.getReference();

        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cartData.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    if (postSnapshot.getKey().toString().equals(singleton.getCurrOrderID())){
                        for (DataSnapshot child: postSnapshot.getChildren()){
                            if (!child.getValue().toString().equals("false") || !child.getValue().toString().equals("true")){
                                cartData.add(new CartData(child.getValue().toString(), 410, child.getKey()));
                            }
                        }
                    }
                }
                notifyChange();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        cartData.add(new CartData("Gyoza", 410));
//        cartData.add(new CartData("Red King", 410));
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
        cartHolder.setKey(cartData.get(i).getKey());
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
