package sg.edu.np.mad.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    TextView name,desc;
    View pfp;
    View largePfp;
    Context context;
    public ListViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        desc = (TextView) itemView.findViewById(R.id.description);
        pfp = itemView.findViewById(R.id.pfp);
        context = itemView.getContext();
        largePfp = itemView.findViewById(R.id.largePfp);
    }
}


