package com.dumagames.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPlayers, etSpies;
    Button btnStart, btnHowToPlay;
    TextView tvVersion;
    int players, spies;
    String place;
    String[] places_persian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        places_persian = getResources().getStringArray(R.array.places_persian);
        final int placeIndex = (int)(Math.random() * (places_persian.length));
        //Edit Texts
        etPlayers = findViewById(R.id.etPlayers);
        etSpies = findViewById(R.id.etSpies);
        //Buttons
        btnStart = findViewById(R.id.btnStart);
        btnHowToPlay = findViewById(R.id.btnHowToPlay);
        //Text Views
        tvVersion = findViewById(R.id.tvVersion);
        tvVersion.setText("version : " + BuildConfig.VERSION_NAME);

        place = places_persian[placeIndex];

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPlayers.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "تعداد بازیکنان را وارد کنید", Toast.LENGTH_SHORT).show();
                }else if (Integer.parseInt(etPlayers.getText().toString()) < 3){
                    Toast.makeText(MainActivity.this, "تعداد بازیکنان باید بیشتر از 3 نفر باشد", Toast.LENGTH_SHORT).show();
                }
                else {
                    players = Integer.parseInt(etPlayers.getText().toString().trim());

                    if (etSpies.getText().toString().isEmpty()){
                        spies = (players/6)+1;
                    }else {
                        spies = Integer.parseInt(etSpies.getText().toString().trim());
                    }

                    Intent intent = new Intent(MainActivity.this, com.dumagames.spyhunt.GameActivity.class);
                    intent.putExtra("playersCount", players);
                    intent.putExtra("spyCount", spies);
                    intent.putExtra("place", place);
                    startActivity(intent);
                }


            }
        });

        btnHowToPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.dumagames.spyhunt.HowToPlay.class);
                startActivity(intent);
            }
        });

    }
}
