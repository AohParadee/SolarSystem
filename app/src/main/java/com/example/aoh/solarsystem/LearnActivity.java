package com.example.aoh.solarsystem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        //Set font
        Typeface myFont = Typeface.createFromAsset(getAssets(), "WRTishKid.ttf");
        TextView mySolarLearn = (TextView) findViewById(R.id.solarLearnText);

        mySolarLearn.setTypeface(myFont);
        //End set font


    }

    private void clickLearn1 (View view) {
        startActivity(new Intent(LearnActivity.this, LearnActivity.class));
    }

}
