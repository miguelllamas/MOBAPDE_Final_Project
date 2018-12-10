package com.example.rolo.ramennagikiosk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

public class ChefView extends AppCompatActivity {

    private RecyclerView recyclerArea;
    private OrderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_view);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        recyclerArea = findViewById(R.id.orderRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerArea.setLayoutManager(layoutManager);
        adapter = new OrderAdapter(getApplicationContext());
        recyclerArea.setAdapter(adapter);
    }
}
