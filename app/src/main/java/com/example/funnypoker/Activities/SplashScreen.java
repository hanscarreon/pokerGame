package com.example.funnypoker.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.funnypoker.Enviroment.Function;
import com.example.funnypoker.R;

public class SplashScreen extends AppCompatActivity {

    ImageView btnPlay, btnInstructions, btnExit;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        init();
        initClickListener();
    }

    private void init() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorWhite));

        btnPlay = findViewById(R.id.btnPlay);
        btnInstructions = findViewById(R.id.btnInstructions);
        btnExit = findViewById(R.id.btnExit);

        Animation animFadein = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.splash);
        btnPlay.startAnimation(animFadein);
    }

    private void initClickListener(){
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function.startActivity(MainActivity.class, SplashScreen.this);
            }
        });

        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function.startActivity(Instructions.class, SplashScreen.this);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (counter == 0) {
            counter = 1;
            Toast.makeText(this, "Press back to exit.", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
    }
}