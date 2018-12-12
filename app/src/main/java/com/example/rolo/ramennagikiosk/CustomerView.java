package com.example.rolo.ramennagikiosk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class CustomerView extends AppCompatActivity {

//    private TextView mTextMessage;

    private int[] menu_images1 = {R.drawable.menu1, R.drawable.menu2, R.drawable.menu4, R.drawable.menu3, R.drawable.menu5, R.drawable.menu6, R.drawable.menu7, R.drawable.menu8, R.drawable.menu9, R.drawable.menu10, R.drawable.menu11, R.drawable.menu12, R.drawable.menu13, R.drawable.menu14, R.drawable.menu15, R.drawable.menu16};
    private int[] menu_images2 = {R.drawable.menu17, R.drawable.menu18, R.drawable.menu19, R.drawable.menu20, R.drawable.menu21, R.drawable.menu22, R.drawable.menu23, R.drawable.menu24, R.drawable.menu25};
    private int[] menu_images3 = {R.drawable.menu26, R.drawable.menu27, R.drawable.menu28, R.drawable.menu29, R.drawable.menu30, R.drawable.menu31, R.drawable.menu32, R.drawable.menu33, R.drawable.menu34, R.drawable.menu35, R.drawable.menu36, R.drawable.menu37, R.drawable.menu38};

    private RecyclerView recyclerArea;
    private MenuAdapter adapter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                    startActivity(intent);
                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        recyclerArea = findViewById(R.id.recyclerArea);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerArea.setLayoutManager(layoutManager);

        adapter = new MenuAdapter(getApplicationContext(), getResources().getStringArray(R.array.menu_items), getResources().getStringArray(R.array.menu_prices), getResources().getStringArray(R.array.menu_descriptions), menu_images1);
        recyclerArea.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView menuHeader = findViewById(R.id.menuHeader);
                menuHeader.setText(R.string.menu1);
                adapter = new MenuAdapter(getApplicationContext(), getResources().getStringArray(R.array.menu_items), getResources().getStringArray(R.array.menu_prices), getResources().getStringArray(R.array.menu_descriptions), menu_images1);
                recyclerArea.setAdapter(adapter);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView menuHeader = findViewById(R.id.menuHeader);
                menuHeader.setText(R.string.menu2);
                adapter = new MenuAdapter(getApplicationContext(), getResources().getStringArray(R.array.menu_items2), getResources().getStringArray(R.array.menu_prices2), getResources().getStringArray(R.array.menu_descriptions2), menu_images2);
                recyclerArea.setAdapter(adapter);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView menuHeader = findViewById(R.id.menuHeader);
                menuHeader.setText(R.string.menu3);
                adapter = new MenuAdapter(getApplicationContext(), getResources().getStringArray(R.array.menu_items3), getResources().getStringArray(R.array.menu_prices3), getResources().getStringArray(R.array.menu_descriptions3), menu_images3);
                recyclerArea.setAdapter(adapter);
            }
        });
    }
}
