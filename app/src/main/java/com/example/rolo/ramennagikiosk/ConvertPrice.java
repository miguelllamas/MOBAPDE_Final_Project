package com.example.rolo.ramennagikiosk;

import java.util.ArrayList;

public class ConvertPrice {

    private ArrayList<String> item_name;
    private ArrayList<Integer> item_price;

    public ConvertPrice(){
        item_name = new ArrayList<>();
        item_price = new ArrayList<>();

        /* RAMEN */
        item_name.add("Original King - Butao"); item_price.add(390);
        item_name.add("Black King - Kuroo"); item_price.add(410);
        item_name.add("Red King - Akao"); item_price.add(410);
        item_name.add("Green King - Midorio"); item_price.add(410);

        /* SIDE DISHES */
        item_name.add("Gyoza"); item_price.add(220);
        item_name.add("Sui-Gyoza"); item_price.add(200);
        item_name.add("Aurora Shrimp"); item_price.add(370);
        item_name.add("Nagi Vanilla Ice Cream"); item_price.add(150);
        item_name.add("Sesame Q"); item_price.add(160);
        item_name.add("Nagi Star Salad"); item_price.add(280);
        item_name.add("Fried Shrimp with Tartar Sauce"); item_price.add(370);
        item_name.add("Pork Katsu Roll"); item_price.add(295);
        item_name.add("Chashu Rice"); item_price.add(190);
        item_name.add("Chicken Karaage"); item_price.add(250);
        item_name.add("Curry Spring Rolls"); item_price.add(170);
        item_name.add("Nagi Chips"); item_price.add(85);

        /* EXTRA ORDERS */
        item_name.add("Kaedama"); item_price.add(70);
        item_name.add("Nori"); item_price.add(60);
        item_name.add("Chasu"); item_price.add(120);
        item_name.add("Tamago"); item_price.add(60);
        item_name.add("Kikurage"); item_price.add(50);
        item_name.add("Kakuni"); item_price.add(120);
        item_name.add("Negi"); item_price.add(60);
        item_name.add("Kyabetsu"); item_price.add(40);
        item_name.add("Japanese Rice"); item_price.add(60);

        /* DRINKS */
        item_name.add("Homemade Iced Tea"); item_price.add(95);
        item_name.add("Mango Juice"); item_price.add(80);
        item_name.add("Orange Juice"); item_price.add(80);
        item_name.add("Pineapple Juice"); item_price.add(80);
        item_name.add("Sprite"); item_price.add(70);
        item_name.add("Coke Regular"); item_price.add(70);
        item_name.add("Coke Zero"); item_price.add(70);
        item_name.add("Royal"); item_price.add(70);
        item_name.add("Mineral Water"); item_price.add(50);
        item_name.add("San Mig Light"); item_price.add(85);
        item_name.add("Asahi"); item_price.add(145);
        item_name.add("Sapporo"); item_price.add(150);
        item_name.add("Kirin"); item_price.add(150);
    }

    public int returnPrice (String n) {
        /* LOOP THROUGH THE ARRAYLISTS */
        for (int i=0; i<item_name.size(); i++){
            if (n.equals(item_name.get(i)))
                return item_price.get(i);
        }

        /* RETURN -1 IF IT ISN'T IN THE MENU LIST */
        return -1;
    }


}