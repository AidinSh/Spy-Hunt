package com.dumagames.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView tvPlace;
    Button btnNextPlayer;
    int playersCount, spyCount, spyIndex, currentPlayer =0;
    boolean hasSeenPlace=false;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvPlace = findViewById(R.id.tvPlace);
        btnNextPlayer = findViewById(R.id.btnNextPlayer);

        playersCount = getIntent().getIntExtra("playersCount", 5);
        spyCount = getIntent().getIntExtra("spyCount", 1);
        place = getIntent().getStringExtra("place");

        final boolean spyIndicator[] = new boolean[playersCount];

        for (int i=0; i<playersCount; i++){
            spyIndicator[i] = false;
        }
        int spyCounter=1;
        while (spyCounter<=spyCount){
            spyIndex = (int) (Math.random() * (playersCount - 1) + 1 );
            if (!spyIndicator[spyIndex]){
                spyIndicator[spyIndex] = true;
                spyCounter++;
            }
        }
                btnNextPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        if(currentPlayer < playersCount) {
                            if (!hasSeenPlace){
                                if(spyIndicator[currentPlayer]){
                                    tvPlace.setText("شما جاسوس هستید!");
                                }else{
                                    tvPlace.setText(place);
                                }
                                if (currentPlayer == playersCount-1){
                                    btnNextPlayer.setText("شروع بازی");
                                }else {
                                    btnNextPlayer.setText("نفر بعدی");
                                }
                                hasSeenPlace=true;
                                currentPlayer++;
                            }else {
                                tvPlace.setText("گوشی را به نفر بعدی بدهید");
                                btnNextPlayer.setText("نمایش محل قرار");
                                hasSeenPlace=false;
                            }
                        }else {
                            Intent intent = new Intent(GameActivity.this, com.dumagames.spyhunt.Timer.class);
                            startActivity(intent);
                        }
                    }
                });
            }
    }
