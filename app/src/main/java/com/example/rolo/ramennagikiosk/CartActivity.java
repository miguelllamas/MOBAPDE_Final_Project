package com.example.rolo.ramennagikiosk;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerArea;
    private CartAdaptor adapter;
    private TextView totalView;
    private Button printButton;
    private Button returnButton;

    private float totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        totalView = findViewById(R.id.totalView);
        printButton = findViewById(R.id.printButton);
        returnButton = findViewById(R.id.returnButton2);
        totalView.setText("Total Bill: ");

        recyclerArea = findViewById(R.id.cartRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerArea.setLayoutManager(layoutManager);
        adapter = new CartAdaptor(getApplicationContext());
        recyclerArea.setAdapter(adapter);
        printButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                promptDialog();
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        FirebaseDatabase fd;
        fd = FirebaseDatabase.getInstance();
        final OrderIDSingleton singleton = OrderIDSingleton.getInstance();
        DatabaseReference dr = fd.getReference();

        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    for (DataSnapshot child: postSnapshot.getChildren()){
                        child.getValue().toString();
                        //add converter here

                        //set total value

                    }

                }
                totalView.setText("Total Bill: ");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void promptDialog(){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

        builder.setTitle("CONFIRM");
        final TextView userInput = new TextView(this);
        final OrderIDSingleton singleton = OrderIDSingleton.getInstance();
        userInput.setText("TOTAL BILL: \n" + "ConfirmationPin: " + singleton.getCurrOrderID());
        builder.setView(userInput);



        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
//                int value;
//                value = Integer.parseInt(userInput.getText().toString());
//                fd = FirebaseDatabase.getInstance();
//                dr = fd.getReference();
//                OrderIDSingleton singleton = OrderIDSingleton.getInstance();
//                for (int i = 0; i < value; i++){
//                    dr.child(singleton.getCurrOrderID()).push().setValue(name);
//                }
                FirebaseDatabase fd = FirebaseDatabase.getInstance();
                DatabaseReference dr = fd.getReference();
                dr.child(singleton.getCurrOrderID()).child("todo").setValue("false");
                singleton.incrementID();
                singleton.setCurrOrderID("ORDERS"+singleton.getID());
                finish();

            }
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}