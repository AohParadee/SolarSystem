package com.example.aoh.solarsystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Set font
        Typeface myFont = Typeface.createFromAsset(getAssets(), "THSarabunNew.ttf");
        TextView myLogin = (TextView) findViewById(R.id.loginText);
        TextView myLoginName = (TextView) findViewById(R.id.loginName);
        TextView myLoginCode = (TextView) findViewById(R.id.loginCode);

        myLogin.setTypeface(myFont);
        //End set font

    }//main method

    private void cilckLoginOk(View view) {
        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
    }//cilckSignUpOk

}//main class