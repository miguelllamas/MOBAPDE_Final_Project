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

    private String[] menu_items;
    private String[] menu_prices;
    private String[] menu_descriptions;
    private int[] menu_images = {R.drawable.menu1};

    public menuAdaptor(Context activity){
        this.menu = new ArrayList<>();
        this.activity = activity;

        menu_items = activity.getResources().getStringArray(R.array.menu_items);
        menu_prices = activity.getResources().getStringArray(R.array.menu_prices);
        menu_descriptions = activity.getResources().getStringArray(R.array.menu_descriptions);

        for(int i = 0; i < menu_items.length; i++) {
            menu.add(new menuData(menu_items[i], Float.valueOf(menu_prices[i]), menu_descriptions[i], menu_images[0]));
        }
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
        menuHolder.setImage(menu.get(i).getImage());
        menuHolder.setButton();
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }
}
