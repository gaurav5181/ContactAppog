package com.example.contactapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context)
    {
        super(context,"contactbook",null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String quarry="CREATE TABlE Contacts (id integer  PRIMARY KEY AUTOINCREMENT,name text,contact text)";
        sqLiteDatabase.execSQL(quarry);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void addData(String str1, String str2) {

        String querry="insert into contacts(name,contact)values('"+str1+"','"+str2+"')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(querry);

    }
}
