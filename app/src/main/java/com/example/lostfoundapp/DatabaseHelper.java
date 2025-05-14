package com.example.lostfoundapp;





import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;
import java.util.*;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "LostFoundDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE items (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, description TEXT, date TEXT, location TEXT, type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS items");
        onCreate(db);
    }

    public void insertItem(ItemModel item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", item.name);
        cv.put("phone", item.phone);
        cv.put("description", item.description);
        cv.put("date", item.date);
        cv.put("location", item.location);
        cv.put("type", item.type);
        db.insert("items", null, cv);
    }

    public List<ItemModel> getAllItems() {
        List<ItemModel> list = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM items", null);
        while (cursor.moveToNext()) {
            list.add(new ItemModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
        }
        cursor.close();
        return list;
    }

    public ItemModel getItem(int id) {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM items WHERE id=?", new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            return new ItemModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        }
        return null;
    }

    public void deleteItem(int id) {
        getWritableDatabase().delete("items", "id=?", new String[]{String.valueOf(id)});
    }
}


