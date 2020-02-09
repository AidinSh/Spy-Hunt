package com.example.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    TextView tvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        tvTimer = findViewById(R.id.tvTimer);

       /* final CountDownTimer timer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvTimer.setText("زمان به پایان رسید!");
            }
        }.start();*/
    }
}
