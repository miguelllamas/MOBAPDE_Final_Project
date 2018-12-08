package com.example.rolo.ramennagikiosk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class chef_view extends AppCompatActivity {

    private RecyclerView recyclerArea;
    private orderAdaptor adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_view);
        recyclerArea = findViewById(R.id.orderRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerArea.setLayoutManager(layoutManager);
        adapter = new orderAdaptor(getApplicationContext());
        recyclerArea.setAdapter(adapter);
    }
}
