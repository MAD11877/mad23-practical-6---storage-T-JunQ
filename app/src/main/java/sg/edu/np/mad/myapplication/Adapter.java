package sg.edu.np.mad.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ListViewHolder> {

    ArrayList<User> data;

    public Adapter(ArrayList<User> d) {
        data = d;
    }

    @NonNull
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new ListViewHolder(v);
    }

    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.name.setText(data.get(position).name);
        holder.desc.setText(data.get(position).description);
        View pfp = holder.pfp;

        User user = data.get(holder.getAdapterPosition());
        pfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog(holder.context,user);
            }
        });

        if (user.name.charAt(user.name.length()-1) == '7')
        {
            View largePfp = holder.largePfp;
            largePfp.setVisibility(View.VISIBLE);
        }
    }

    public int getItemCount() {
        return data.size();
    }

    public void getDialog(Context c , User u){

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Profile");
        builder.setMessage(u.name);
        builder.setCancelable(true);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent mainActivity = new Intent(c,MainActivity.class);
                mainActivity.putExtra("ViewUser", u);
                c.startActivity(mainActivity);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
