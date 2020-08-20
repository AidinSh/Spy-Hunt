package com.dumagames.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TimerWithName extends AppCompatActivity {

    TextView tvTimer, tvTimerText;
    Button btnMenu, btnRestart, btnReveal;

    ArrayList<String> spyNames = new ArrayList<String>();
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_with_name);

        tvTimer = findViewById(R.id.tvTimer);
        tvTimerText = findViewById(R.id.tvTimerText);
        btnMenu = findViewById(R.id.btnMenu);
        btnRestart = findViewById(R.id.btnRestart);
        btnReveal = findViewById(R.id.btnReveal);

        spyNames = getIntent().getStringArrayListExtra("spyNames");
        place = getIntent().getStringExtra("place");

        btnMenu.setVisibility(View.GONE);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimerWithName.this, com.dumagames.spyhunt.MainActivity.class);
                startActivity(intent);
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimerWithName.this, com.dumagames.spyhunt.MainActivity.class);
                startActivity(intent);
            }
        });



        final CountDownTimer timer = new CountDownTimer(300000, 1000) {

            public void onTick(long millisUntilFinished) {
                int minutesUntilFinish = (int) millisUntilFinished/1000/60;
                tvTimer.setText(minutesUntilFinish + ":" + (millisUntilFinished/1000 % 60));

            }

            public void onFinish() {
                tvTimer.setText("زمان به پایان رسید!");
                tvTimer.setTextSize(40);
                tvTimerText.setVisibility(View.INVISIBLE);
                btnMenu.setVisibility(View.VISIBLE);
                btnRestart.setVisibility(View.GONE);
            }
        }.start();

        btnReveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTimer.setTextSize(30);
                tvTimer.setGravity(Gravity.CENTER);
                tvTimer.setText("مکان :" + "\n" + place + "\n\n" + "جاسوس(جاسوسان) :" + "\n" + spyNames);
                btnReveal.setVisibility(View.GONE);
                tvTimerText.setVisibility(View.GONE);
                timer.cancel();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TimerWithName.this, com.dumagames.spyhunt.MainActivity.class);
        startActivity(intent);
    }
}
