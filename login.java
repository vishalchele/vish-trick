package com.example.vishal.joke;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
EditText editText2,editText4;
    SQLiteOpenHelper mOpenHelper;
    SQLiteDatabase db;
    Button button;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText4 = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button);
        mOpenHelper = new DatabaseHelper(this);
        db = mOpenHelper.getReadableDatabase();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =editText2.getText().toString();
                String phone =editText4.getText().toString();
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_2 + "=? AND " + DatabaseHelper.COL_3 + "=?", new String[]{name,phone});
                if(cursor!=null){
                    if(cursor.getCount() > 0){
                        cursor.moveToNext();
                        Toast.makeText(login.this,"login successfully",Toast.LENGTH_LONG).show();
                    }else
                    {
                        Toast.makeText(login.this,"error username or password wrong",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
