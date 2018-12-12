package com.example.rolo.ramennagikiosk;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CashierView extends AppCompatActivity {

    private EditText pin;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_view);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        pin = findViewById(R.id.CNPin);
        submit = findViewById(R.id.confirmButton);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase fd = FirebaseDatabase.getInstance();
                final DatabaseReference dr = fd.getReference();


                dr.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        boolean found = false;
                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                            // TODO: handle the post
                            if (pin.getText().toString().equals(postSnapshot.getKey().toString())){
                                dr.child(pin.getText().toString()).child("todo").setValue("true");
                                found = true;
                            }
                        }

                        if (found){
                            promptDialog();
                        } else {
                            promptDialog2();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }

    public void promptDialog(){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

        builder.setTitle("Success");
        final TextView userInput = new TextView(this);
        final OrderIDSingleton singleton = OrderIDSingleton.getInstance();
        userInput.setText("Order successfully registered.");
        builder.setView(userInput);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                pin.setText("");
            }
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void promptDialog2(){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

        builder.setTitle("Error");
        final TextView userInput = new TextView(this);
        final OrderIDSingleton singleton = OrderIDSingleton.getInstance();
        userInput.setText("Invalid code entered. Could not find associated order.");
        builder.setView(userInput);

        builder.setPositiveButton(R.string.ok2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                pin.setText("");
            }
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}
