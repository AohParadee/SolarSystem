package com.example.aoh.solarsystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //Set font
        Typeface myFont = Typeface.createFromAsset(getAssets(), "THSarabunNew.ttf");
        TextView mySignin = (TextView) findViewById(R.id.signinText);
        TextView myLogin = (TextView) findViewById(R.id.loginText);
        TextView myName = (TextView) findViewById(R.id.name);
        TextView mySurname = (TextView) findViewById(R.id.surname);
        TextView myStudentCode = (TextView) findViewById(R.id.studentCode);
        TextView myTeacherName = (TextView) findViewById(R.id.teacherName);
        TextView mySigninOk = (TextView) findViewById(R.id.signinOk);
        TextView myLoginOk = (TextView) findViewById(R.id.loginOk);

        mySignin.setTypeface(myFont);
        myLogin.setTypeface(myFont);
        //End set font


    }//main method

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUp.class));
    }

}//main class

class SignUp extends AppCompatActivity {

    //Explicit SignUp
    private EditText editText, editText2, editText3, editText4;
    private String nameString, surnameString, studentCodeString, teacherString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget SignUp
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        //End Bind Widget

    public void clickSignUp(View view) {

        //Get Value from Edit Text
        nameString = editText.getText().toString().trim();
        surnameString = editText2.getText().toString().trim();
        studentCodeString = editText3.getText().toString().trim();
        teacherString = editText4.getText().toString().trim();

        //Check Space
        if (nameString.equals("") || surnameString.equals("") || studentCodeString.equals("") || teacherString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่องค่ะ");

        }//if

    }//clickSignUp

}

}//SignUp
