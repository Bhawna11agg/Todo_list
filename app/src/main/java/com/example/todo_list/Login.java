package com.example.todo_list;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

public class Login extends AppCompatActivity {
    ImageView i0;
    EditText edt1, edt2, edt3;
    Button btn;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        i0 = (ImageView) findViewById(R.id.i0);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cheers);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        i0.setImageDrawable(roundedBitmapDrawable);
        edt1 = findViewById(R.id.editText1);
        edt2 = findViewById(R.id.editText2);
        edt3 = findViewById(R.id.editText3);
        btn = findViewById(R.id.Submit);
        Intent intent =getIntent();
        sharedPreferences = this.getSharedPreferences("com.example.todo_list", MODE_PRIVATE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String name=edt1.getText().toString();
                 try{
                     int phone=Integer.parseInt(edt2.getText().toString());
                 }
                 catch(NumberFormatException nfe){
                 }
                 String mail=edt3.getText().toString();
                if(Empty(name,mail)) {
                        sharedPreferences.edit().putString(SharedPreference.NAME, name).apply();
                        sharedPreferences.edit().putString(SharedPreference.MAIL, mail).apply();
                        sharedPreferences.edit().putBoolean("firstTime",false).apply();
                    }
                }
        });
    }
    boolean Empty(String name, String mail){
        boolean t=true;
            if(name.isEmpty()){
            edt1.setError("A username is required!!");
                t=false;
            }
            if(mail.isEmpty()){
               edt3.setError("Please enter an email");
                t=false;
        }
        return t;
    }

}
