package com.satyajitghosh.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText title;
    private Button button;
    private RadioButton impYes;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        impYes=findViewById(R.id.impYes);
        button=findViewById(R.id.button);
        dbHandler = new DBHandler(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoTitle=title.getText().toString();
                String ImportantString="0";
                if(impYes.isChecked()){
                    ImportantString="1";
                }
                dbHandler.addItems(todoTitle,ImportantString);
                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
                //Log.d("DatabaseRecord",arr.get(arr.size()-1).title);
                Intent intent=new Intent(MainActivity.this,ViewTodoList.class);
                startActivity(intent);
            }
        });
    }
}