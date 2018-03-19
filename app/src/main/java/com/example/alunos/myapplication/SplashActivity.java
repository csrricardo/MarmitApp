package com.example.alunos.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;


public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        Intent intent = new Intent (SplashActivity.this, MainActivity.class);
        startActivity (intent);
        finish ();
    }
}