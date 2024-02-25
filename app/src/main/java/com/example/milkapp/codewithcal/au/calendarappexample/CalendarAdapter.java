package com.example.milkapp.codewithcal.au.calendarappexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.milkapp.R;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder>
{
    private final ArrayList<String> daysOfMonth;
    private final OnItemListener onItemListener;
    String strtodaysDate;
    public CalendarAdapter(ArrayList<String> daysOfMonth, OnItemListener onItemListener,int todaysDate)
    {
        this.daysOfMonth = daysOfMonth;
        this.onItemListener = onItemListener;
        this.strtodaysDate = Integer.toString(todaysDate);

    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        return new CalendarViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position)
    {
        holder.dayOfMonth.setText(daysOfMonth.get(position));
        holder.newTextView.setText(daysOfMonth.get(position));
        if(daysOfMonth.get(position).equals(strtodaysDate)){
            holder.view.setVisibility(View.VISIBLE);
        }else{
            holder.view.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount()
    {
        return daysOfMonth.size();
    }

    public interface  OnItemListener
    {
        void onItemClick(int position, String dayText,View view);
    }

    public void updateAdapter(String selectedDate){
        strtodaysDate=selectedDate;
        notifyDataSetChanged();
    }


}
