package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = findViewById(R.id.username);
        Intent listEnd = getIntent();
        User user = (User)listEnd.getSerializableExtra("ViewUser");
        name.setText(user.name);
        Intent messageGroup = new Intent(MainActivity.this,MessageGroup.class);
        Button follow = findViewById(R.id.follow);
        if (user.followed)
        {
            follow.setText("Unfollow");
        }
        else{
            follow.setText("Follow");
        }
        follow.setOnClickListener(v -> {
            if (user.followed)
            {
                follow.setText("Follow");
                user.followed = false;
                Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
            }
            else{
                follow.setText("Unfollow");
                user.followed = true;
                Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
            }
        });

        Button message = findViewById(R.id.message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(messageGroup);
            }
        });
    }
}



