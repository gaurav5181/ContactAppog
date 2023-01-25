package DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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
    public Cursor viewdata()
    {
          String query = "select * from Contacts order by name collate nocase";
          SQLiteDatabase db = getReadableDatabase();
          Cursor cursor = db.rawQuery(query,null);
          return cursor;


    }
    public void updatedata(int id,String name,String contact){


        String querry="update contacts set name='"+name+"', contact = '"+contact+"' where id = "+id+"";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(querry);



    }
    public void deletedat(int id){

       String querry="delete from contacts where id ="+id+"";
       SQLiteDatabase db = getWritableDatabase();
       db.execSQL(querry);




    }


}
