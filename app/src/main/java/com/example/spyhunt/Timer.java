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

        final CountDownTimer timer = new CountDownTimer(300000, 1000) {

            public void onTick(long millisUntilFinished) {
                int minutesUntilFinish = (int) millisUntilFinished/1000/60;
                tvTimer.setText(minutesUntilFinish + ":" + ((millisUntilFinished - (minutesUntilFinish*60))/ 1000));
            }

            public void onFinish() {
                tvTimer.setText("زمان به پایان رسید!");
            }
        }.start();
    }
}
