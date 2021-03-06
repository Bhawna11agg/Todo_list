package com.example.todo_list;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arr = new ArrayList<String>();
    ArrayList<String> arr1 = new ArrayList<>();
    EditText edt;
    Button btn;
    RecyclerView my_recycle;
    Adapter3 adapter;
    final Databaseprep mydb = new Databaseprep(MainActivity.this);
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.buttonAdd);
        edt = findViewById(R.id.text);
        my_recycle = findViewById(R.id.my_recycle);

        Cursor raw = mydb.getAllData();
        while (raw.moveToNext()) {
            arr1.add(raw.getString(1));
        }
        arrayList.addAll(arr1);
        my_recycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter3(arrayList,this);
        my_recycle.setAdapter(adapter);

        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("first", "default", NotificationManager.IMPORTANCE_DEFAULT));
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Notification simple = new NotificationCompat.Builder(MainActivity.this, "first")
                        .setContentTitle("Do this")
                        .setContentText(edt.getText().toString())
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .build();
                notificationManager.notify(1, simple);
                arrayList.add(edt.getText().toString());
                mydb.insertData(edt.getText().toString());
                adapter.notifyItemChanged(arrayList.size() - 1);
                edt.setText("");
            }
        });
    }
    public void delete(int x){
        mydb.deleteData(arr1.get(x));
    }
}

