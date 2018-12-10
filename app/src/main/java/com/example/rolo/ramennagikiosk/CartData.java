package com.example.rolo.ramennagikiosk;

public class CartData {
    private String item;
    private float price;
    private String key;

    public CartData(String item, float price, String key) {
        this.item = item;
        this.price = price;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getItem() {
        return item;
    }

    public float getPrice() {
        return price;
    }
}
