package com.example.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView tvPlace;
    Button btnNextPlayer;
    int players, spy, counter=1;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        spy = (int) (Math.random() * (players - 1) + 1 );

        tvPlace = findViewById(R.id.tvPlace);
        btnNextPlayer = findViewById(R.id.btnNextPlayer);


        players = getIntent().getIntExtra("players", 5);
        place = getIntent().getStringExtra("place");

        while(counter < players*2){

                btnNextPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        if((counter%2) != 0) {
                            tvPlace.setText("گوشی را به نفر بعدی بدهید");
                            tvPlace.setVisibility(View.VISIBLE);
                            btnNextPlayer.setText("نمایش محل قرار");
                            counter++;
                        }else {
                            tvPlace.setText(place);
                            tvPlace.setVisibility(View.VISIBLE);
                            btnNextPlayer.setText("نفر بعدی");
                            counter++;
                        }
                    }
                });
            }
        }
    }
