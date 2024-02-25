package com.example.milkapp;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

public class CalendarAdapters extends BaseAdapter {
    private final Context context;
    private final List<String> dayNumbers;

    public CalendarAdapters(Context context, List<String> dayNumbers) {
        this.context = context;
        this.dayNumbers = dayNumbers;
    }

    @Override
    public int getCount() {
        return dayNumbers.size();
    }

    @Override
    public Object getItem(int position) {
        return dayNumbers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(context);
            textView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(dayNumbers.get(position));
        return textView;
    }
}
