package com.example.vishal.joke;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SQLiteOpenHelper mOpenHelper;
    SQLiteDatabase db;
    EditText editText,editText3;
    Button button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   editText = (EditText) findViewById(R.id.editText);
        editText3= (EditText) findViewById(R.id.editText3);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        mOpenHelper = new DatabaseHelper(this);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = mOpenHelper.getWritableDatabase();
                String name = editText.getText().toString();
                String phone = editText3.getText().toString();
                insertData(name,phone);
                Toast.makeText(MainActivity.this,"Registor successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void insertData(String name,String phone)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,name);
        contentValues.put(DatabaseHelper.COL_3,phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}
