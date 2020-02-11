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
    int playersCount, spyIndex, currentPlayer =1;
    boolean hasSeenPlace=false;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvPlace = findViewById(R.id.tvPlace);
        btnNextPlayer = findViewById(R.id.btnNextPlayer);

        playersCount = getIntent().getIntExtra("playersCount", 5);
        place = getIntent().getStringExtra("place");
        spyIndex = (int) (Math.random() * (playersCount - 1) + 1 );

                btnNextPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        if(currentPlayer <= playersCount) {
                            if (!hasSeenPlace){
                                if(currentPlayer == spyIndex){
                                    tvPlace.setText("شما جاسوس هستید!");
                                }else{
                                    tvPlace.setText(place);
                                }
                                if (currentPlayer == playersCount){
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
                            Intent intent = new Intent(GameActivity.this, com.example.spyhunt.Timer.class);
                            startActivity(intent);
                        }
                    }
                });
            }

    }
