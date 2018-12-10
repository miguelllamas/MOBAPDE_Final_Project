package com.example.rolo.ramennagikiosk;

public class MenuData {
    private String name;
    private String desc;
    private float price;
    private int image;

    public MenuData(String name, float price, String desc, int image) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDesc(){ return desc; }

    public int getImage(){ return image; }
}
