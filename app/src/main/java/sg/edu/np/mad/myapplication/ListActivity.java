package sg.edu.np.mad.myapplication;


import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.Math;
import java.util.ArrayList;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<User> profiles = new ArrayList<>(20);
        for (int i = 0; i<=20; i++)
        {
            profiles.add(new User("Name" +(int) (Math.random()*1000000000+1),String.valueOf((int) (Math.random()*1000000000+1))
                    ,i,false ));
        }

        RecyclerView rv = findViewById(R.id.listView);
        Adapter a = new Adapter(profiles);
        rv.setAdapter(a);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }



}
