package com.example.todo_list;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Loading extends AppCompatActivity {
TextView txt1,txt2;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        sharedPreferences=getSharedPreferences("com.example.todo_list",MODE_PRIVATE);
    }
    public void onClick1(final View v){
        if(sharedPreferences.getBoolean("firstTime",true)) {
            AlertDialog alertDialogBuilder = new AlertDialog.Builder(v.getContext())
                    .setTitle("Welcome Geek!!")
                    .setCancelable(false)
                    .setMessage("You have to first Sign Up to Continue ")
                    .setPositiveButton("Sign IN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        }
                    })
                    .create();
            alertDialogBuilder.show();
        }
        else{
            Intent intent = new Intent(v.getContext(),SharedPreference.class);
            startActivity(intent);
        }
    }
    public void onClick2(final View v){
        if(sharedPreferences.getBoolean("firstTime",true)){
            AlertDialog alertDialogBuilder=new AlertDialog.Builder(v.getContext())
                    .setTitle("Welcome Geek!!")
                    .setCancelable(false)
                    .setMessage("You have to first Sign Up to Continue ")
                    .setPositiveButton("Sign IN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);

                        }
                    })
                    .create();
            alertDialogBuilder .show();
        }
        else{
            Intent intent = new Intent(v.getContext(),MainActivity.class);
            startActivity(intent);
        }

    }
}
