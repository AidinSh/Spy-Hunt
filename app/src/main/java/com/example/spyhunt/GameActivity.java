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
            if((counter%2) != 0){
                btnNextPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v1) {
                        tvPlace.setText("گوشی را به نفر بعدی بدهید");
                        btnNextPlayer.setText("نمایش محل قرار");
                        counter++;
                    }
                });
            }else{
                btnNextPlayer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v2) {
                        tvPlace.setText(place);
                        btnNextPlayer.setText("نفر بعدی");
                        counter++;
                    }
                });
            }
            tvPlace.setVisibility(View.VISIBLE);
        }

        btnNextPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {

                Intent intent = new Intent(GameActivity.this, com.example.spyhunt.Timer.class);
                startActivity(intent);
            }
        });

    }
}
