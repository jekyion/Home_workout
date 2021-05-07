package com.home_wrokout.Alarm_RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.home_wrokout.R;

import java.util.ArrayList;

public class Alarms_Adapter extends RecyclerView.Adapter<Alarms_Adapter.AlarmsViewHolder> {

    private ArrayList<RecyclerView_Item> mArrayList;

    public static class AlarmsViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHour;
        public TextView textViewDaysOfWeek;

        public AlarmsViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            this.textViewHour = itemView.findViewById(R.id.text_hour);
            this.textViewDaysOfWeek = itemView.findViewById(R.id.text_days_of_week);
        }
    }

    public Alarms_Adapter(ArrayList<RecyclerView_Item> arrayList){
        this.mArrayList = arrayList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public AlarmsViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        AlarmsViewHolder alarmsViewHolder = new AlarmsViewHolder(view);
        return alarmsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull Alarms_Adapter.AlarmsViewHolder holder, int position) {
        RecyclerView_Item currentItem = mArrayList.get(position);

        holder.textViewHour.setText(currentItem.getHour());
        holder.textViewDaysOfWeek.setText(currentItem.getDays_of_week());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}