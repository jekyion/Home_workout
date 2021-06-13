package com.home_wrokout.Alarm_RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.home_wrokout.MainActivity;
import com.home_wrokout.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Alarm_activity extends AppCompatActivity {

    private Alarm_ItemCollector alarm_itemCollector;

    private RecyclerView mRecyclerView;
    private Alarms_Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private TableCollectionInteger tableCollectionInteger;

    private Button buttonAddItem;
    private String EXTRA_POSITION = "EXTRA_POSITION";
    private String EXTRA_HOUR = "EXTRA_HOUR";
    private String EXTRA_MINUTE = "EXTRA_MINUTE";
    private String EXTRA_DAYSOFWEEK = "EXTRA_DAYSOFWEEK";
    private String GSON_ARRAY_ALARM_LIST = "GSON_ARRAY_ALARM_LIST";
    private String INTEGER_TABLE = "INTEGER_TABLE";
    private String INTEGER_TABLE_tabSize = "INTEGER_TABLE_tabSize";
//    private String EXTRA_DOSETALARM = "EXTRA_DOSETALARM";

    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        pref = getPreferences(MODE_PRIVATE);
        editor = pref.edit();

        tableCollectionInteger = new TableCollectionInteger();
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

    public void startAlarm(RecyclerView_Item item) {
        Calendar c = Calendar.getInstance();
//            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//            Intent intent = new Intent(this, AlertReciver.class);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
//            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 5 * 1000, pendingIntent);
        ArrayList<Integer> takenIndexList = new ArrayList<>();
        for ( Calendar calendar: item.getCalendars() ) {
            int index = tableCollectionInteger.getIndeks();
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            tableCollectionInteger.add(index);
            Intent intent = new Intent(this, AlertReciver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, index, intent, 0);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 5 * 1000, pendingIntent);
            takenIndexList.add(index);
        }
        item.setTakenSlots(takenIndexList);
        item.setOn(!item.getOn());
    }

    public void stopAlarm(RecyclerView_Item item) {
        if ( item.getTakenSlots() == null)
            return;
        for ( int index: item.getTakenSlots() ){
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, AlertReciver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, index, intent, 0);
            alarmManager.cancel(pendingIntent);
        }
        item.setOn(!item.getOn());
        deleteAlarm(item);
    }

    public void deleteAlarm(RecyclerView_Item item) {
        if( item.getTakenSlots() == null )
            return;
        for ( int index: item.getTakenSlots()){
            tableCollectionInteger.delete(index);
        }
    }

    public void moveToAlarmAdd(int position){
        Intent intent = new Intent(this, Alarm_add_activity.class);
        intent.putExtra(EXTRA_POSITION, position);
        startActivity(intent);
    }

    public void LoadAlarms(){
//        int tabSize = pref.getInt(INTEGER_TABLE_tabSize, 0);
//        String savedString = pref.getString(INTEGER_TABLE, "");
//        StringTokenizer st = new StringTokenizer(savedString, ",");
//        Integer[] savedList = new Integer[tabSize];
//        for (int i = 0; i < tabSize; i++) {
//            savedList[i] = Integer.parseInt(st.nextToken());
//        }
//        tableCollectionInteger.setTablica(savedList);

        Gson gson = new Gson();
        String jsonItem = pref.getString(GSON_ARRAY_ALARM_LIST, "");
        if( jsonItem != "") {
            alarm_itemCollector = gson.fromJson(jsonItem, Alarm_ItemCollector.class);
        }
    }

    public void CommitToSharedPreferences(){
//        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
//        Integer[] list = tableCollectionInteger.getTablica();
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < list.length; i++) {
//            str.append(list[i]).append(",");
//        }
//        editor.putString(INTEGER_TABLE, str.toString());
//        editor.putInt(INTEGER_TABLE_tabSize, tableCollectionInteger.getTabSize());

        Gson gson = new Gson();
        String jsonItem = gson.toJson(alarm_itemCollector);
        editor.putString(GSON_ARRAY_ALARM_LIST, jsonItem);
        editor.commit();
    }

    public void addAlarmItem(int position, String days_of_week, int hour, int minute){
        RecyclerView_Item item = new RecyclerView_Item(days_of_week,hour,minute);
        System.out.println(position+" przy addAlarmItem: "+item.getOn());
        alarm_itemCollector.add(item);
        mAdapter.notifyItemInserted(position);
        CommitToSharedPreferences();
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
                deleteAlarm(alarm_itemCollector.getItem(position));
                alarm_itemCollector.remove(position);
                mAdapter.notifyItemRemoved(position);
                CommitToSharedPreferences();
            }
        }, new Alarms_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (!alarm_itemCollector.getItem(position).getOn())
                    startAlarm(alarm_itemCollector.getItem(position));
                else
                    stopAlarm(alarm_itemCollector.getItem(position));
                mAdapter.notifyItemChanged(position);
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