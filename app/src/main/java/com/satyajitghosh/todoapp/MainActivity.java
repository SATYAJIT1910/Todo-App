package com.satyajitghosh.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText title;
    private Button button;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        button=findViewById(R.id.button);
        dbHandler = new DBHandler(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoTitle=title.getText().toString();
                dbHandler.addItems(todoTitle,false);
                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
                ArrayList<DataBaseModel> arr=dbHandler.getItems();
                Log.d("DatabaseRecord",arr.get(arr.size()-1).title);
            }
        });
    }
}