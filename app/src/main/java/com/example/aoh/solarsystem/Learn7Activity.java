package com.example.aoh.solarsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Learn7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn7);
    }//main method

    public void clickHome(View view) {
        startActivity(new Intent(Learn7Activity.this, MenuActivity.class));
    }//clickHome

}//main class
