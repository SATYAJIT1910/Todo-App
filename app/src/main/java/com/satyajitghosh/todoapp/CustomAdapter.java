package com.satyajitghosh.todoapp;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CustomAdapter extends ArrayAdapter<DataBaseModel> {
    private DBHandler dbHandler;
    private ArrayList<DataBaseModel> arrayList;
    public CustomAdapter(@NonNull Context context,@NonNull ArrayList<DataBaseModel> arrayList) {
        super(context,0, arrayList);
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }
        TextView textView1 = currentItemView.findViewById(R.id.titleView);
        textView1.setText(arrayList.get(position).getTitle());
        int value=Integer.parseInt(arrayList.get(position).getImp());
        if(value==1){
            currentItemView.setBackgroundResource(R.drawable.rounded_corner_important);
       }
        Log.d("ImportantStatus",arrayList.get(position).getImp());

        Button button=currentItemView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler = new DBHandler(getContext());
                dbHandler.deleteItems(arrayList.get(position).getTitle());
               arrayList.remove(position);
             //   textView1.setPaintFlags(textView1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                notifyDataSetChanged();
            }
        });
        return currentItemView;
    }


}
