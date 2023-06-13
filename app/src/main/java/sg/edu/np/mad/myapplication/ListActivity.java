package sg.edu.np.mad.myapplication;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;


import android.os.Bundle;



public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        UserDBHandler dbHandler = new UserDBHandler(this);
//        dbHandler.onUpgrade(dbHandler.getWritableDatabase(),1,1);
//        ArrayList<User> profiles = new ArrayList<>();
//        for (int i = 0; i<=20; i++)
//        {
//            Random r = new Random();
//            User u = new User("Name" + (int) (Math.random()*1000000000+1),"Description "+  (int) (Math.random()*1000000000+1)
//                    ,0,r.nextBoolean());
//            profiles.add(u);
//            dbHandler.adduser(u);
//        }

        RecyclerView rv = findViewById(R.id.listView);
        Adapter a = new Adapter(dbHandler.getUsers());
        rv.setAdapter(a);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
