package com.example.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextPlayerActivity extends AppCompatActivity {

    Button btnSeePlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_player);

        btnSeePlace = findViewById(R.id.btnSeePlace);

        btnSeePlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextPlayerActivity.this, com.example.spyhunt.GameActivity.class);
                startActivity(intent);
            }
        });
    }
}
