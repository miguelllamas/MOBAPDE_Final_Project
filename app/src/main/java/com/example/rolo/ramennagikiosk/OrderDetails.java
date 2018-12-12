package com.example.rolo.ramennagikiosk;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderDetails extends AppCompatActivity {
    private String orders;
    private String key;

    private TextView orderView;
    private Button back;
    private Button archive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        orderView = (TextView) findViewById(R.id.listView);
        orderView.setMovementMethod(new ScrollingMovementMethod());

        back = findViewById(R.id.returnButton);
        archive = findViewById(R.id.markFinish);
        orders = getIntent().getStringExtra("orders");
        key = getIntent().getStringExtra("key");

        orderView.setText(orders);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        archive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Archive item in database or delete? :D
                FirebaseDatabase fd = FirebaseDatabase.getInstance();
                final DatabaseReference dr = fd.getReference();
                Log.d("KEY TAG", "KEY VALUE: " + key);


                dr.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                            // TODO: handle the post
                            Log.d("CHECK TAG", "PostSnapshot VALUE: " + postSnapshot.toString());
                            if (key.equals(postSnapshot.getKey().toString())){
                                dr.child(key).child("todo").setValue("false");
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                finish();
            }
        });
    }
}
