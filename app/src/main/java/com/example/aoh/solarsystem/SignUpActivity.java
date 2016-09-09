package com.example.aoh.solarsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    //Explicit SignUp
    private EditText editText, editText2, editText3, editText4;
    public String nameString, surnameString, studentCodeString, teacherString;
    public Button signUpButton;

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


    }//main method


    public void clickSignUp(View view) {

        // new DatabaseClass
        final DatabaseClass mydb = new DatabaseClass(this);

        //Bind Widget SignUp
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        //End Bind Widget

        //Get Value from Edit Text
        nameString = editText.getText().toString().trim();
        surnameString = editText2.getText().toString().trim();
        studentCodeString = editText3.getText().toString().trim();
        teacherString = editText4.getText().toString().trim();

        //showAddStudentDialog();

        //Check Space
       if (checkSpace()) {

           MyAlert myAlert = new MyAlert();
           myAlert.myDialog(this, "ข้อมูลไม่ครบ", "กรุณากรอกข้อมูลให้ครบทุกช่องค่ะ");

       } else if (nameString.equals("Paradee") || studentCodeString.equals("12345")) {

           MyAlert myAlert = new MyAlert();
           myAlert.myDialog(this, "ข้อมูลซ้ำ", "ชื่อหรือรหัสนี้ถูกใช้ไปแล้ว กรุณากรอกข้อมูลใหม่ค่ะ");

       } else {

           long okSignUp = mydb.InsertData(null,
                   editText.getText().toString(),
                   editText2.getText().toString(),
                   editText3.getText().toString(),
                   editText4.getText().toString());
           editText.setText(null);
           editText2.setText(null);
           editText3.setText(null);
           editText4.setText(null);

           Toast.makeText(SignUpActivity.this,"สมัครใช้งานเรียบร้อยแล้ว",
                   Toast.LENGTH_LONG).show();
           startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
           SignUpActivity.this.finish();
       } // if

    }// SignUpActivity

    public void clickSignUpOk() {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }//clickSignUpOk

    public boolean checkSpace() {
        return nameString.equals("") ||
                surnameString.equals("") ||
                studentCodeString.equals("") ||
                teacherString.equals(""); //เมื่อมีช่องว่าง
    }// CheckSpace

}//main class
