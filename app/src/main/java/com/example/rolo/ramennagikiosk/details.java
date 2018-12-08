package com.example.rolo.ramennagikiosk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class details extends AppCompatActivity {

    private String name;
    private String desc;
    private int price;

    private TextView itemName;
    private TextView priceAndDesc;
    private Button addCart;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        itemName = findViewById(R.id.itemNameD);
        priceAndDesc = findViewById(R.id.itemPriceAndDesc);
        addCart = findViewById(R.id.addButton);
        back = findViewById(R.id.backDetails);

        name = getIntent().getStringExtra("name");
        desc = getIntent().getStringExtra("desc");
        price = getIntent().getIntExtra("price", -1);

        //Setting values of xml objects
        setName();
        priceAndDesc.setText(price +" PHP\n\n" + desc);
        addCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setName(){
        itemName.setText(name);
    }
}
