package com.example.rolo.ramennagikiosk;

import android.app.Application;
import com.google.firebase.database.FirebaseDatabase;

public class FireApp extends Application{

    @Override
    public void onCreate(){
        super.onCreate();

        FirebaseDatabase.getInstance();
    }
}
