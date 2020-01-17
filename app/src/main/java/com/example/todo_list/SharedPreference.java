package com.example.todo_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class SharedPreference extends AppCompatActivity {
TextView txt1,txt2;
SharedPreferences sharedPreferences;
    static final String MYPREFERENCES = "com.example.todo_list";
    static final String NAME = "name";
    static final String MAIL="mail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        Intent intent=getIntent();
        txt1=findViewById(R.id.textView2);
        txt2=findViewById(R.id.textView3);
        sharedPreferences = getSharedPreferences(MYPREFERENCES,MODE_PRIVATE);
        txt1.setText(sharedPreferences.getString(NAME,""));
        txt2.setText(sharedPreferences.getString(MAIL,""));
    }
}
