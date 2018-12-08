package com.example.rolo.ramennagikiosk;

public class CartData {
    private String item;
    private float price;

    public CartData(String item, float price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public float getPrice() {
        return price;
    }
}
