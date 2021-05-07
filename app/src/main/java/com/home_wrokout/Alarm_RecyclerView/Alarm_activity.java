package com.home_wrokout.Alarm_RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.home_wrokout.R;

import java.util.ArrayList;

public class Alarm_activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);


        ArrayList<RecyclerView_Item> alarmList = new ArrayList<>();
        alarmList.add(new RecyclerView_Item("9:00","pn, wt, sr"));
        alarmList.add(new RecyclerView_Item("23:00","sob, nd"));

        mRecyclerView = findViewById(R.id.Alarms_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new Alarms_Adapter(alarmList);


        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}