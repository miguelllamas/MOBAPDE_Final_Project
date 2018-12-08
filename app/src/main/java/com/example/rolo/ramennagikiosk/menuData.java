package com.example.rolo.ramennagikiosk;

public class menuData {
    private String name;
    private String desc;
    private float price;

    public menuData(String name, float price, String desc) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDesc(){ return desc; };
}
