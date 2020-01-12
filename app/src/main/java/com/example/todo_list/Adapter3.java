package com.example.todo_list;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.ViewAdapter>{
       ArrayList<String> arrayList;
    public Adapter3(ArrayList<String> arrayList1) {
            this.arrayList = arrayList1;
        }

        @NonNull
        @Override
        public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            View itemView=inflater.inflate(R.layout.list_items,parent,false);
            return new ViewAdapter(itemView);
        }

    @Override
    public void onBindViewHolder(@NonNull final ViewAdapter holder, final int position) {

        holder.txt1.setText(arrayList.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position != 0) {
                    arrayList.remove(position);
                    notifyDataSetChanged();
                }
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

