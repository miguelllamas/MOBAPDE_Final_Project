package com.example.rolo.ramennagikiosk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ChefButton;
    Button CustomerButton;
    Button CashierButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChefButton = findViewById(R.id.chefButon);
        CustomerButton = findViewById(R.id.custButton);
        CashierButton = findViewById(R.id.cashButton);

        ChefButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, chef_view.class);
//                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        CustomerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, customer_view.class);
                startActivity(intent);
            }
        });
        CashierButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cashier_view.class);
                startActivity(intent);
            }
        });
    }


}
