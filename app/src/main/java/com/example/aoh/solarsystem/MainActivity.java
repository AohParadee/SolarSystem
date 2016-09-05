package com.example.aoh.solarsystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

//        MyAlert myAlert = new MyAlert();
//        myAlert.myDialog(this,"นี่คือ My Alert", "เรายังอยู่นะ");

    }//main method

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

    public void clickLoginMain(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

}//main class