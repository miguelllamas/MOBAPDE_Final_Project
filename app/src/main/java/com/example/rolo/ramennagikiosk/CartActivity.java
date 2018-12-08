package com.example.rolo.ramennagikiosk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerArea;
    private CartAdaptor adapter;
    private TextView totalView;
    private Button printButton;
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        totalView = findViewById(R.id.totalView);
        printButton = findViewById(R.id.printButton);
        returnButton = findViewById(R.id.returnButton2);

        recyclerArea = findViewById(R.id.cartRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerArea.setLayoutManager(layoutManager);
        adapter = new CartAdaptor(getApplicationContext());
        recyclerArea.setAdapter(adapter);

        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
