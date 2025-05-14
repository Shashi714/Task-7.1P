package com.example.lostfoundapp;





import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    DatabaseHelper db;
    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
        db = new DatabaseHelper(this);
        items = db.getAllItems();

        if (items == null || items.size() == 0) {
            Toast.makeText(this, "No items found!", Toast.LENGTH_SHORT).show();
            return;
        }

        List<String> displayList = new ArrayList<>();
        for (ItemModel i : items) {
            displayList.add(i.type + ": " + i.name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, ItemDetailActivity.class);
            intent.putExtra("id", items.get(position).id);
            startActivity(intent);
        });
    }
}

