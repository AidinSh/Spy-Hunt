package com.example.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPlayers;
    Button btnStart, btnHowToPlay;
    int players;
    String[] places = getResources().getStringArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlayers = findViewById(R.id.etPlayers);
        btnStart = findViewById(R.id.btnStart);
        btnHowToPlay = findViewById(R.id.btnHowToPlay);


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

                    Intent intent = new Intent(MainActivity.this, com.example.spyhunt.GameActivity.class);
                    intent.putExtra("players", players);
                    startActivity(intent);
                }
            }
        });

    }
}
