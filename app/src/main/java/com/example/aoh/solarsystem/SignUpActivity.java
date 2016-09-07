package com.example.aoh.solarsystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    //Explicit SignUp
    private EditText editText, editText2, editText3, editText4;
    public String nameString, surnameString, studentCodeString, teacherString;
    public Button signUpButton;
    //public TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Set font
        Typeface myFont = Typeface.createFromAsset(getAssets(), "THSarabunNew.ttf");
        TextView mySignup = (TextView) findViewById(R.id.signUpText);
        TextView myName = (TextView) findViewById(R.id.name);
        TextView mySurname = (TextView) findViewById(R.id.surname);
        TextView myStudentCode = (TextView) findViewById(R.id.studentCode);
        TextView myTeacherName = (TextView) findViewById(R.id.teacherName);

        mySignup.setTypeface(myFont);
        //End set font

        //Bind Widget SignUp
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        //showText = (TextView) findViewById(R.id.showText);
        //End Bind Widget

    }//main method

   public void clickSignUp(View view) {

        //Get Value from Edit Text
        nameString = editText.getText().toString().trim();
        surnameString = editText2.getText().toString().trim();
        studentCodeString = editText3.getText().toString().trim();
        teacherString = editText4.getText().toString().trim();
        //showText.setText("Hello"+nameString);

        //Check Space
       if (checkSpace()) {

           MyAlert myAlert = new MyAlert();
           myAlert.myDialog(this, "ข้อมูลไม่ครบ", "กรุณากรอกข้อมูลให้ครบทุกช่องค่ะ");

       } else {

           Intent intent = new Intent(this, CheckUser.class);
           //intent.putExtra("nameString", editText);
           startActivity(intent);

           clickSignUpOk();
       } // if

    }// SignUpActivity

    public void clickSignUpOk() {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }


    public boolean checkSpace() {
        return nameString.equals("") ||
                surnameString.equals("") ||
                studentCodeString.equals("") ||
                teacherString.equals(""); //เมื่อมีช่องว่าง
    }// CheckSpace

}//main class
