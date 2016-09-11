package com.example.aoh.solarsystem;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private ImageView imvGirl;
    private AnimationDrawable objAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imvGirl = (ImageView) findViewById(R.id.imvGirl);

        imvGirl.setBackgroundResource(R.anim.girl_kid);

    }//main method

    public void clickLearn(View view) {
        startActivity(new Intent(MenuActivity.this, LearnActivity.class));
    }//clickLearn

}//main class
