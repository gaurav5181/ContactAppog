package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText str1,str2;
    Button addbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        str1=findViewById(R.id.ename);
        str2=findViewById(R.id.enumber);
        addbtn=findViewById(R.id.addbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String stre1=str1.getText().toString();
                String stre2=str2.getText().toString();
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                dbHelper.addData(stre1,stre2);
            }
        });
    }
}