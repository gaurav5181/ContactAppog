package Activity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.R;

import java.util.ArrayList;

import DataBase.DBHelper;

public class Contact_Activity extends AppCompatActivity
{
    ListView listView;
    ArrayList<Integer> Arrid = new ArrayList<>();
    ArrayList<String>  ArrNme = new ArrayList<>();
    ArrayList<String> Arrcontact = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        DBHelper dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.viewdata();
        while (cursor.moveToNext()){

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String contact = cursor.getString(2);

            Arrid.add(id);
            ArrNme.add(name);
            Arrcontact.add(contact);
        }

        listView = findViewById(R.id.contactli);
        ContactListAdapter contactListAdapter = new ContactListAdapter(Contact_Activity.this,ArrNme,Arrcontact,Arrid);
        listView.setAdapter(contactListAdapter);


    }

}






