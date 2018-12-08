package com.example.rolo.ramennagikiosk;

import java.util.ArrayList;

public class orderData {
    private ArrayList<String> orders;
    private String orderNumber;

    public orderData(ArrayList<String> orders, String orderNumber) {
        this.orders = orders;
        this.orderNumber = orderNumber;
    }

    public void addOrder(String foodItem){
        orders.add(foodItem);
    }

    public void removeOrder(String foodItem){
        orders.remove(foodItem);
    }

    public ArrayList<String> getOrders() {
        return orders;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
