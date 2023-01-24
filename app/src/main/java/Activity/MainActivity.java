package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import DataBase.DBHelper;
import com.example.contactapp.R;


public class MainActivity extends AppCompatActivity {

    EditText str1,str2;
    Button addbtn,showbtn;
    ImageView edit,delete;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        str1=findViewById(R.id.ename);
        str2=findViewById(R.id.enumber);
        addbtn=findViewById(R.id.addbtn);
        showbtn=findViewById(R.id.showbtn);

        dbHelper = new DBHelper(MainActivity.this);

        int id = getIntent().getIntExtra("id",0);
        String name = getIntent().getStringExtra("name");
        String contact = getIntent().getStringExtra("number");
        if(getIntent().getExtras()!=null)
        {
            str1.setText(""+name);
            str2.setText(""+contact);
            showbtn.setVisibility(View.GONE);
            ((ImageView)findViewById(R.id.imageoo)).setImageResource(R.drawable.file);

        }


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stre1 = str1.getText().toString();
                String stre2 = str2.getText().toString();
                if(getIntent().getExtras()==null) {

                    if (!stre1.isEmpty() && !stre2.isEmpty()) {
                        dbHelper.addData(stre1, stre2);
                        str1.setText("");
                        str2.setText("");
                        Toast.makeText(MainActivity.this, "data added", Toast.LENGTH_SHORT).show();
                    } else {

                        if(stre1.isEmpty())
                        {
                            str1.setError("enter name");

                        }
                        if(stre2.isEmpty())
                        {

                            str2.setError("enter number");

                        }



                    }
                }
                else
                {

                    dbHelper.updatedata(id,stre1,stre2);

                    str1.setText("");
                    str2.setText("");
                    Toast.makeText(MainActivity.this, "data update", Toast.LENGTH_SHORT).show();



                }
            }
        });

        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Contact_Activity.class);
                startActivity(intent);

            }
        });


    }
}