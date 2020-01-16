package com.example.todo_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databaseprep extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student_data.db";
    public static final String TABLE_NAME = "Student_table5";
    public static final String COL_1="ID";
    public static final String COL_2 = "Name";
    public Databaseprep(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create TABLE "+ TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String Name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(COL_2,Name);
        long result= db.insert(TABLE_NAME,null,content);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor raw=db.rawQuery("select * from "+TABLE_NAME,null);
        return raw;
    }
    public int deleteData(String x){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,"Name=?", new String[]{x});
    }
}