package com.satyajitghosh.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataBaseModel> {

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

        TextView textView2 = currentItemView.findViewById(R.id.impView);
        textView2.setText(arrayList.get(position).getImp());

        return currentItemView;
    }


}
