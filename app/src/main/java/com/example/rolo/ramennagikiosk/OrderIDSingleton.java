package com.example.rolo.ramennagikiosk;

import java.util.ArrayList;
import java.util.Random;

public class OrderIDSingleton {
    // static variable single_instance of type Singleton
    private static OrderIDSingleton single_instance = null;
    private ArrayList<String> orders;
    private String currOrderID;
    private static int ID;

    // private constructor restricted to this class itself
    private OrderIDSingleton() {
        orders = new ArrayList<>();
    }

    // static method to create instance of Singleton class
    public static OrderIDSingleton getInstance()
    {
        if (single_instance == null){
            single_instance = new OrderIDSingleton();
            Random rand = new Random();

            ID = rand.nextInt(400000) + 100000;
        }

        return single_instance;
    }

    public void addOrderID(String id){
        orders.add(id);
    }

    public ArrayList<String> getOrders() {
        return orders;
    }

    public String getCurrOrderID() {
        return currOrderID;
    }

    public void setCurrOrderID(String currOrderID) {
        this.currOrderID = currOrderID;
    }

    public int getID(){
        return ID;
    }

    public void incrementID(){
        Random rand = new Random();
        ID = rand.nextInt(400000) + 100000;
    }
}
