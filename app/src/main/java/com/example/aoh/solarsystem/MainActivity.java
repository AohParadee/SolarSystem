package com.example.aoh.solarsystem;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText editText, editText2, editText3, editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //Bind Widget
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);


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
    }
}//main method

