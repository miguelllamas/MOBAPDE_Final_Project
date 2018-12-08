package com.example.rolo.ramennagikiosk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class menuAdaptor extends RecyclerView.Adapter<menuHolder>{

    private ArrayList<menuData> menu;
    private Context activity;

    public menuAdaptor(Context activity){
        this.menu = new ArrayList<>();
        this.activity = activity;

        //place holder values for the menu
        menu.add(new menuData("Original King - Butao", 390, activity.getResources().getString(R.string.origDesc)));
        menu.add(new menuData("Black King - Kuroo", 410, activity.getResources().getString(R.string.blackkingDesc)));
        menu.add(new menuData("Red King - Akao", 410, activity.getResources().getString(R.string.redkingDesc)));
        menu.add(new menuData("Green King - Midorio", 410, activity.getResources().getString(R.string.greenkingDesc)));
        menu.add(new menuData("Gyoza", 220, activity.getResources().getString(R.string.defaultDesc)));
        menu.add(new menuData("Sui-Gyoza", 200, activity.getResources().getString(R.string.defaultDesc)));
        menu.add(new menuData("Aurora Shrimp", 370, activity.getResources().getString(R.string.defaultDesc)));
        menu.add(new menuData("Nagi Vanilla Ice Cream", 150, activity.getResources().getString(R.string.defaultDesc)));
        menu.add(new menuData("Seseme Q", 160, activity.getResources().getString(R.string.defaultDesc)));

    }

    @NonNull
    @Override
    public menuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.menu_item, viewGroup, false);
        menuHolder holder = new menuHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull menuHolder menuHolder, int i) {
        menuHolder.setDesc(menu.get(i).getDesc());
        menuHolder.setName(menu.get(i).getName());
        menuHolder.setPrice(menu.get(i).getPrice());
        menuHolder.setButton();
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }
}
