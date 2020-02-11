package com.dumagames.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    TextView tvTimer, tvTimerText;
    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        tvTimer = findViewById(R.id.tvTimer);
        tvTimerText = findViewById(R.id.tvTimerText);
        btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setVisibility(View.GONE);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Timer.this, com.dumagames.spyhunt.MainActivity.class);
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
            }
        }.start();
    }
}
