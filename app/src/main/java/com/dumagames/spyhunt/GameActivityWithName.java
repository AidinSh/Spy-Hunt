package com.dumagames.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivityWithName extends AppCompatActivity {

    TextView tvHint, tvPlayerRole;
    EditText etPlayerName;
    Button btnNext;

    int playersCount, spyCount, spyIndex, currentPlayer;
    boolean hasSeenPlace=false;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_with_name);

        tvHint = findViewById(R.id.tvHint);
        tvPlayerRole = findViewById(R.id.tvPlayerRole);
        etPlayerName = findViewById(R.id.etPlayerName);
        btnNext = findViewById(R.id.btnNext);

        playersCount = getIntent().getIntExtra("playersCount", 5);
        spyCount = getIntent().getIntExtra("spyCount", 1);
        place = getIntent().getStringExtra("place");

        final boolean spyIndicator[] = new boolean[playersCount];

        final ArrayList<String> playerNames = new ArrayList<String>();
        final ArrayList<String> spyNames = new ArrayList<String>();

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

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPlayerName.getText().toString().trim().isEmpty()){
                    Toast.makeText(GameActivityWithName.this, "لطفا نام را وارد کنید", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (currentPlayer < playersCount) {
                        if (!hasSeenPlace) {
                            etPlayerName.setVisibility(View.INVISIBLE);
                            tvPlayerRole.setVisibility(View.VISIBLE);
                            tvHint.setText("دکمه ی نفر بعدی را بزنید و گوشی را به نفر بعد بدهید");
                            if (spyIndicator[currentPlayer]) {
                                playerNames.add(etPlayerName.getText().toString().trim());
                                spyNames.add(etPlayerName.getText().toString().trim());
                                tvPlayerRole.setText("شما جاسوس هستید!");
                            } else {
                                playerNames.add(etPlayerName.getText().toString().trim());
                                tvPlayerRole.setText(place);
                            }
                            if (currentPlayer == playersCount - 1) {
                                tvHint.setVisibility(View.INVISIBLE);
                                btnNext.setText("شروع بازی");
                            } else {
                                btnNext.setText("نفر بعدی");
                            }
                            hasSeenPlace = true;
                            currentPlayer++;
                        } else {
                            tvHint.setText("لطفا نام خود را در کادر وارد کنید");
                            tvPlayerRole.setVisibility(View.INVISIBLE);
                            etPlayerName.setVisibility(View.VISIBLE);
                            etPlayerName.setText("");
                            btnNext.setText("نمایش محل قرار");
                            hasSeenPlace = false;
                        }
                    } else {
                        Intent intent = new Intent(GameActivityWithName.this, com.dumagames.spyhunt.TimerWithName.class);
                        intent.putStringArrayListExtra("spyNames", spyNames);
                        intent.putExtra("place", place);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
