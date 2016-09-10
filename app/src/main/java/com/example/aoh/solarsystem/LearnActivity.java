package com.example.aoh.solarsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }//main method

    public void clickLearn1(View view) {
        startActivity(new Intent(LearnActivity.this, Learn1Activity.class));
    }//clickLearn

}//main class
