package com.example.lostfoundapp;



import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {
    TextView name, date, location;
    Button btnRemove;
    DatabaseHelper db;
    int itemId;
    ItemModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        name = findViewById(R.id.detailName);
        date = findViewById(R.id.detailDate);
        location = findViewById(R.id.detailLocation);
        btnRemove = findViewById(R.id.btnRemove);

        db = new DatabaseHelper(this);
        itemId = getIntent().getIntExtra("id", -1);
        item = db.getItem(itemId);

        name.setText(item.type + " " + item.name);
        date.setText(item.date);
        location.setText("At " + item.location);

        btnRemove.setOnClickListener(v -> {
            db.deleteItem(itemId);
            finish();
        });
    }
}

