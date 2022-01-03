package com.satyajitghosh.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME="myTodoDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME ="TodoTable" ;
    private static final String ID_COL ="ID";
    private static final String TITLE_COL = "TITLE";
    private static final String IMP_COL = "IMP";

    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+TABLE_NAME+"("+ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT,"+TITLE_COL+" TEXT,"+ IMP_COL+" TEXT)";
        sqLiteDatabase.execSQL(query);
    }
    public void addItems(String title,String imp){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TITLE_COL,title);
        values.put(IMP_COL,imp);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public ArrayList<DataBaseModel> getItems(){
        ArrayList<DataBaseModel> arr=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursorItems = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursorItems.moveToFirst()) {
            do {
                arr.add(new DataBaseModel(
                        cursorItems.getString(1),
                        cursorItems.getString(2)
                ));
            } while (cursorItems.moveToNext());

        }
        cursorItems.close();



        return arr;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
