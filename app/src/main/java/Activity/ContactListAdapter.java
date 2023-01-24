package Activity;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.contactapp.R;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

import DataBase.DBHelper;


public class ContactListAdapter extends BaseAdapter {
    Activity activity;
    ImageView popup;
    ArrayList<Integer>id;
    ArrayList<String> arrName;
    ArrayList<String> arrcontact;
    TextView textView_Name,textView_Contact;

    public ContactListAdapter(Activity activity, ArrayList<String> arrName, ArrayList<String> arrcontact,ArrayList<Integer> id)
    {
        this.activity = activity;
        this.arrName = arrName;
        this.arrcontact = arrcontact;
        this.id=id;
    }

    @Override
    public int getCount() {
        return arrName.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(activity).inflate(R.layout.contact_items, viewGroup, false);
        textView_Name=view.findViewById(R.id.nametxt);
        textView_Contact=view.findViewById(R.id.numbertxt);
        popup=view.findViewById(R.id.popup);


        textView_Name.setText(arrName.get(i));
        textView_Contact.setText(arrcontact.get(i));

        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(activity,view);
                popupMenu.inflate(R.menu.menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem)
                    {
                        if(menuItem.getItemId()==R.id.menu_edit)
                        {
                            Intent intent = new Intent(activity,MainActivity.class);
                            intent.putExtra("id",id.get(i));
                            intent.putExtra("name",arrName.get(i));
                            intent.putExtra("number",arrcontact.get(i));
                            activity.startActivity(intent);

                        }else if(menuItem.getItemId()==R.id.menu_delete)
                        {
                            DBHelper dbHelper = new DBHelper(activity);
                            dbHelper.deletedat(id.get(i));
                            id.remove(i);
                            arrName.remove(i);
                            arrcontact.remove(i);
                            notifyDataSetChanged();

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        return view;
    }

}


