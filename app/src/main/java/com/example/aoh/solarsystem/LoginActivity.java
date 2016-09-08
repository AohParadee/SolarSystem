package com.example.aoh.solarsystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    //Explicit SignUp
    private EditText editText11, editText12;
    public String nameLoginString, codeLoginString;
    public Button loginButton;


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

        //Bind Widget SignUp
        editText11 = (EditText) findViewById(R.id.editText11);
        editText12 = (EditText) findViewById(R.id.editText12);
        loginButton = (Button) findViewById(R.id.loginButton);

    }//main method

    public void clickLogin(View view) {

        //Get Value from Edit Text
        nameLoginString = editText11.getText().toString().trim();
        codeLoginString = editText12.getText().toString().trim();

        //Check Space
        if (checkSpace()) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "ข้อมูลไม่ครบ", "กรุณากรอกข้อมูลให้ครบทุกช่องค่ะ");

        } else if (nameLoginString.equals("Paradee") && codeLoginString.equals("12345")) {

            clickLoginOk();

        } else {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "ข้อมูลผิด", "ชื่อหรือรหัสผิด กรุณากรอกใหม่ค่ะ");

        } // if

    }// SignUpActivity

    public void clickLoginOk() {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }//clickSignUpOk

    public boolean checkSpace() {
        return nameLoginString.equals("") || codeLoginString.equals(""); //เมื่อมีช่องว่าง
    }// CheckSpace

}//main class
