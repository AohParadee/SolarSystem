package com.example.aoh.solarsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Learn1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn1);
    }//main method

    public void clickHome(View view) {
        startActivity(new Intent(Learn1Activity.this, MenuActivity.class));
    }//clickHome



}//main class
