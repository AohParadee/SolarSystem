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
    }//clickLearn1

    public void clickLearn2(View view) {
        startActivity(new Intent(LearnActivity.this, Learn2Activity.class));
    }//clickLearn2

    public void clickLearn3(View view) {
        startActivity(new Intent(LearnActivity.this, Learn3Activity.class));
    }//clickLearn3

    public void clickLearn4(View view) {
        startActivity(new Intent(LearnActivity.this, Learn4Activity.class));
    }//clickLearn4

    public void clickLearn5(View view) {
        startActivity(new Intent(LearnActivity.this, Learn5Activity.class));
    }//clickLearn5

    public void clickLearn6(View view) {
        startActivity(new Intent(LearnActivity.this, Learn6Activity.class));
    }//clickLearn6

    public void clickLearn7(View view) {
        startActivity(new Intent(LearnActivity.this, Learn7Activity.class));
    }//clickLearn7

    public void clickLearn8(View view) {
        startActivity(new Intent(LearnActivity.this, Learn8Activity.class));
    }//clickLearn8

}//main class
