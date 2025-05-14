package com.example.lostfoundapp;




import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAdvertActivity extends AppCompatActivity {
    EditText name, phone, desc, date, location;
    RadioGroup postType;
    Button btnSave;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advert);

        db = new DatabaseHelper(this);
        name = findViewById(R.id.inputName);
        phone = findViewById(R.id.inputPhone);
        desc = findViewById(R.id.inputDesc);
        date = findViewById(R.id.inputDate);
        location = findViewById(R.id.inputLocation);
        postType = findViewById(R.id.radioGroup);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String type = ((RadioButton)findViewById(postType.getCheckedRadioButtonId())).getText().toString();
            db.insertItem(new ItemModel(name.getText().toString(), phone.getText().toString(),
                    desc.getText().toString(), date.getText().toString(), location.getText().toString(), type));
            Toast.makeText(this, "Advert saved", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}

