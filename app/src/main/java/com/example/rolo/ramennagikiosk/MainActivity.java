package com.example.rolo.ramennagikiosk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button ChefButton;
    Button CustomerButton;
    Button CashierButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OrderIDSingleton singleton = OrderIDSingleton.getInstance();
        singleton.addOrderID(singleton.getOrderCTR()+"ORDERS"+singleton.getID());
        singleton.setCurrOrderID(singleton.getOrderCTR()+"ORDERS"+singleton.getID());

        if (singleton.getOrderCTR() < 10){
            singleton.addOrderID("0"+singleton.getOrderCTR()+"ORDERS"+singleton.getID());
            singleton.setCurrOrderID("0"+singleton.getOrderCTR()+"ORDERS"+singleton.getID());
        }

        ChefButton = findViewById(R.id.chefButton);
        CustomerButton = findViewById(R.id.custButton);
        CashierButton = findViewById(R.id.cashButton);

        ChefButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                promptDialog("CHEF");
            }
        });
        CustomerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomerView.class);
                startActivity(intent);
                finish();
            }
        });
        CashierButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                promptDialog("CASHIER");
            }
        });
    }

    public void promptDialog(String value) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.prompt);
        final EditText userInput = new EditText(this);
        builder.setView(userInput);
        final String type = value;
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                String value;
                Log.d("INPUT TAG", "INPUT MSG: " + userInput.getText().toString());
                value = userInput.getText().toString();
                if (type.equals("CHEF")) {
                    if (value.equals("admin123")) {
                        Intent intent = new Intent(MainActivity.this, ChefView.class);
//                intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);
                        finish();
                    } else {
                        Log.d("INPUT TAG", "CHEF FAIL");
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.fail, Toast.LENGTH_SHORT);
                        toast.show();
                    }

                } else if (type.equals("CASHIER")) {
                    if (value.equals("admin123")) {
                        Intent intent = new Intent(MainActivity.this, CashierView.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Log.d("INPUT TAG", "CASHIER FAIL");
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.fail, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
