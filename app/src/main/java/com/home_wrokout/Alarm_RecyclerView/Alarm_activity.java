package com.home_wrokout.Alarm_RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.home_wrokout.MainActivity;
import com.home_wrokout.R;

import java.util.ArrayList;

public class Alarm_activity extends AppCompatActivity {

    private Alarm_ItemCollector alarm_itemCollector;

    private RecyclerView mRecyclerView;
    private Alarms_Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    private Button buttonAddItem;
    private String EXTRA_POSITION = "EXTRA_POSITION";
    private String EXTRA_HOUR = "EXTRA_HOUR";
    private String EXTRA_MINUTE = "EXTRA_MINUTE";
    private String EXTRA_DAYSOFWEEK = "EXTRA_DAYSOFWEEK";
    private String GSON_ARRAY_ALARM_LIST = "GSON_ARRAY_ALARM_LIST";
//    private String EXTRA_DOSETALARM = "EXTRA_DOSETALARM";

    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        pref = getPreferences(MODE_PRIVATE);
        editor = pref.edit();

        alarm_itemCollector = new Alarm_ItemCollector();
        LoadAlarms();
        createAlarmRecyclerView();

        buttonAddItem = findViewById(R.id.button_add_alarm_item);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mAdapter.getItemCount();
                moveToAlarmAdd(position);
            }
        });


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                System.out.println("No Extras");
            } else {
                int position = extras.getInt(EXTRA_POSITION);
                int hour = extras.getInt(EXTRA_HOUR);
                int minute = extras.getInt(EXTRA_MINUTE);
                String days_of_week = extras.getString(EXTRA_DAYSOFWEEK);
                addAlarmItem(position, days_of_week, hour, minute);
            }
        } else {
            int position = (Integer) savedInstanceState.getSerializable(EXTRA_POSITION);
            int hour = (Integer) savedInstanceState.getSerializable(EXTRA_HOUR);
            int minute =(Integer) savedInstanceState.getSerializable(EXTRA_MINUTE);
            String days_of_week = (String) savedInstanceState.getSerializable(EXTRA_DAYSOFWEEK);
            addAlarmItem(position, days_of_week, hour, minute);
        }
    }

    public void moveToAlarmAdd(int position){
        Intent intent = new Intent(this, Alarm_add_activity.class);
        intent.putExtra(EXTRA_POSITION, position);
        startActivity(intent);
    }

    public void LoadAlarms(){
        Gson gson = new Gson();
        String json = pref.getString(GSON_ARRAY_ALARM_LIST, "");
        if( json != "" ) {
            alarm_itemCollector = gson.fromJson(json, Alarm_ItemCollector.class);
        }
    }

    public void addAlarmItem(int position, String days_of_week, int hour, int minute){
        RecyclerView_Item item = new RecyclerView_Item(days_of_week,hour,minute);
        alarm_itemCollector.add(item);
        mAdapter.notifyItemInserted(position);
        CommitToSharedPreferences();
    }

    public void CommitToSharedPreferences(){
        Gson gson = new Gson();
        String json = gson.toJson(alarm_itemCollector);
        editor.putString(GSON_ARRAY_ALARM_LIST, json);
        editor.commit();
    }

    public void createAlarmRecyclerView(){
        mRecyclerView = findViewById(R.id.Alarms_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new Alarms_Adapter(alarm_itemCollector.getList());


        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new Alarms_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                alarm_itemCollector.remove(position);
                mAdapter.notifyItemRemoved(position);
                CommitToSharedPreferences();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}