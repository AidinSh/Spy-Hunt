package com.example.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView tvPlace;
    Button btnNextPlayer;
    int players, spy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        spy = (int) (Math.random() * (players - 1) + 1 );

        tvPlace = findViewById(R.id.tvPlace);
        btnNextPlayer = findViewById(R.id.btnNextPlayer);

        players = getIntent().getIntExtra("players", 5);

        for(int i = 1; i <= players; i++){
            if(i == spy){
                tvPlace.setText("شما جاسوس هستید !");
            }else{
                tvPlace.setText();
            }
        }
    }



}
