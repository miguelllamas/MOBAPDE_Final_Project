package com.example.rolo.ramennagikiosk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderDetails extends AppCompatActivity {
    private String orders;

    private TextView orderView;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        orderView = findViewById(R.id.listView);
        back = findViewById(R.id.returnButton);
        orders = getIntent().getStringExtra("orders");

        orderView.setText(orders);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
