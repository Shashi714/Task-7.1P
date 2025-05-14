package com.example.lostfoundapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnCreate, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        btnShow = findViewById(R.id.btnShow);

        btnCreate.setOnClickListener(v -> startActivity(new Intent(this, CreateAdvertActivity.class)));
        btnShow.setOnClickListener(v -> startActivity(new Intent(this, ListActivity.class)));
    }
}

