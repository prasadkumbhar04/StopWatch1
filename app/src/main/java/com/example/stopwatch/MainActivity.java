package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button startbtn,stopbtn,resetbtn;
    Chronometer chronometer;
    long stopTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn=(Button)findViewById(R.id.startbtn);
        stopbtn=(Button) findViewById(R.id.stopbtn);
        resetbtn=(Button) findViewById(R.id.resetbtn);
        chronometer=(Chronometer) findViewById(R.id.Chronometer);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime()+stopTime);
                chronometer.start();
                startbtn.setVisibility(View.GONE);
                stopbtn.setVisibility(View.VISIBLE);
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTime=chronometer.getBase()-SystemClock.elapsedRealtime();
                chronometer.stop();
                startbtn.setVisibility(View.VISIBLE);
                stopbtn.setVisibility(View.GONE);
            }
        });
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                stopTime=0;
                startbtn.setVisibility(View.VISIBLE);
                stopbtn.setVisibility(View.GONE );

            }
        });
    }
}