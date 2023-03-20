package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView time, click;
    Button przycisk, startButton;

    CountDownTimer timer;

    int t = 30;
    int c = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = (TextView)findViewById(R.id.time);
        click = (TextView)findViewById(R.id.click);
        przycisk = (Button)findViewById(R.id.przycisk);
        startButton = (Button)findViewById(R.id.startButton);

        startButton.setEnabled(true);
        przycisk.setEnabled(false);

        timer = new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                t--;
                time.setText(t);
            }


            @Override
            public void onFinish() {
                startButton.setEnabled(true);
                click.setEnabled(false);
                time.setText("0");
            }
        };
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c++;
                click.setText(c);

            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                startButton.setEnabled(false);
                przycisk.setEnabled(true);
                c=0;
                t=30;
                time.setText(t);
                click.setText(c);
            }
        });

    }

}