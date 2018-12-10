package com.example.rolo.ramennagikiosk;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderHolder extends RecyclerView.ViewHolder {

    private TextView orderNumber;
    private String orderNos;
    private String desc;
    private String orders; //to send in the other activity
    private ArrayList<String> ordersList;
    private Button viewMore;

    public OrderHolder(@NonNull View itemView) {
        super(itemView);
        orderNumber = itemView.findViewById(R.id.orderNumber);
        viewMore = itemView.findViewById(R.id.viewOrder);
    }

    public void setOrderNumber(String oNumber){
        orderNos = oNumber;
        orderNumber.setText(orderNos);
    }

    public void setButton(){
        viewMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String strOrders = "";
                for (int i = 0; i < ordersList.size(); i++){
                    if (i == 0) {
                        strOrders = ordersList.get(i);
                    }else{
                        strOrders = strOrders + "\n" + ordersList.get(i);
                    }
                }
                Intent intent = new Intent(v.getContext(), OrderDetails.class);
                intent.putExtra("orders", strOrders);
                intent.putExtra("key", orderNos);
                v.getContext().startActivity(intent);
            }
        });
    }

    public void setOrdersList(ArrayList<String> ordersList) {
        this.ordersList = ordersList;
    }
}
