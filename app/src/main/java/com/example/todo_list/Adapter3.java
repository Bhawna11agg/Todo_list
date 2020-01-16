package com.example.todo_list;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class Adapter3 extends  RecyclerView.Adapter<Adapter3.ViewAdapter>{
    ArrayList<String> arrayList;
    MainActivity mainActivity;
    AlertDialog.Builder alertDialogueBuilder;
    public Adapter3(ArrayList<String> arrayList1,MainActivity mainActivity1) {
        this.arrayList = arrayList1;
        this.mainActivity=mainActivity1;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.list_items,parent,false);
        return new ViewAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewAdapter holder, final int position){
        holder.txt1.setText(arrayList.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialogBuilder=new AlertDialog.Builder(v.getContext())
                .setTitle("ALERT")
                        .setCancelable(false)
             .setMessage("Are you sure you want to delete the task "+arrayList.get(position)+" ?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mainActivity.delete(position);
                                arrayList.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                       })
                     .create();
                       alertDialogBuilder .show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewAdapter extends RecyclerView.ViewHolder{
        TextView txt1;
        Button btn;
        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            txt1=(TextView)itemView.findViewById(R.id.textView);
            btn=(Button)itemView.findViewById(R.id.button);
        }
    }
}
