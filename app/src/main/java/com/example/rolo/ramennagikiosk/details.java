package com.example.rolo.ramennagikiosk;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class details extends AppCompatActivity {

    private String name;
    private float price;
    private String desc;
    private int image;

    private TextView itemName;
    private TextView itemPrice;
    private TextView itemDescription;
    private ImageView itemImageFull;
    private Button addCart;
    private Button back;

    //firebase
    private FirebaseDatabase fd;
    private DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);
        itemDescription = findViewById(R.id.itemDescription);
        itemImageFull = findViewById(R.id.itemImageFull);
        addCart = findViewById(R.id.addButton);
        back = findViewById(R.id.backDetails);

        name = getIntent().getStringExtra("name");
        price = getIntent().getFloatExtra("price", -1);
        desc = getIntent().getStringExtra("desc");
        image = getIntent().getIntExtra("image", -1);

        DecimalFormat df2 = new DecimalFormat("0.00");
        //Setting values of xml objects
        setName();
        itemImageFull.setImageResource(image);
        itemPrice.setText("PHP " + df2.format(price));
        itemDescription.setText(desc);
        addCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                promptDialog();
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

    public void promptDialog(){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

        builder.setTitle(R.string.prompt1);
        final EditText userInput = new EditText(this);
        builder.setView(userInput);
        userInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        userInput.setRawInputType(Configuration.KEYBOARD_12KEY);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                int value;
                try{
                    value = Integer.parseInt(userInput.getText().toString());
                    fd = FirebaseDatabase.getInstance();
                    dr = fd.getReference();
                    OrderIDSingleton singleton = OrderIDSingleton.getInstance();
                    for (int i = 0; i < value; i++){
                        dr.child(singleton.getCurrOrderID()).push().setValue(name);
                    }
                    finish();
                } catch (NumberFormatException e){
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.invalid, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        android.app.AlertDialog dialog = builder.create();
        dialog.show();
    }
}
