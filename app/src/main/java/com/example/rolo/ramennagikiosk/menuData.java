package com.example.rolo.ramennagikiosk;

public class menuData {
    String name;
    String desc;
    int price;

    public menuData(String name, int price, String desc) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc(){ return desc; };
}
