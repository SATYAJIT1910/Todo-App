package com.satyajitghosh.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewTodoList extends AppCompatActivity {
    private DBHandler dbHandler;
    private ListView listView;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo_list);
        listView=findViewById(R.id.list);
        floatingActionButton=findViewById(R.id.addfloatbtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ViewTodoList.this,TodoEntryActivity.class);
                startActivity(intent);
            }
        });


        dbHandler = new DBHandler(ViewTodoList.this);
        ArrayList<DataBaseModel> arr=dbHandler.getItems();

        CustomAdapter c=new CustomAdapter(getApplicationContext(),arr);

        listView.setAdapter(c);
    }
}