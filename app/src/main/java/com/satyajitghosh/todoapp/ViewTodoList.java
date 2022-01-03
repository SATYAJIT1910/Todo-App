package com.satyajitghosh.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewTodoList extends AppCompatActivity {
    private DBHandler dbHandler;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo_list);
        listView=findViewById(R.id.list);

        dbHandler = new DBHandler(ViewTodoList.this);
        ArrayList<DataBaseModel> arr=dbHandler.getItems();

        CustomAdapter c=new CustomAdapter(getApplicationContext(),arr);

        listView.setAdapter(c);
    }
}