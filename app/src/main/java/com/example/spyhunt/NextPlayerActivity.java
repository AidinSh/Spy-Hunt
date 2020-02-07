package com.example.spyhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class NextPlayerActivity extends AppCompatActivity {

    Button btnSeePlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_player);

        btnSeePlace = findViewById(R.id.btnSeePlace);
    }
}
