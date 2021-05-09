package com.home_wrokout.Alarm_RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.home_wrokout.R;

import java.util.ArrayList;

public class Alarm_activity extends AppCompatActivity {

    private ArrayList<RecyclerView_Item> alarmList;

    private RecyclerView mRecyclerView;
    private Alarms_Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    private Button buttonAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        createExampleAlarmList();
        createAlarmRecyclerView();

        buttonAddItem = findViewById(R.id.button_add_alarm_item);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mAdapter.getItemCount();
                addAlarmItem(position);
            }
        });
    }

    public void addAlarmItem(int position){
        alarmList.add(new RecyclerView_Item("11:00","pn, wt"));
        mAdapter.notifyItemInserted(position);
    }

    public void createExampleAlarmList(){
        alarmList = new ArrayList<>();
        alarmList.add(new RecyclerView_Item("9:00","pn, wt, sr"));
        alarmList.add(new RecyclerView_Item("23:00","sob, nd"));
    }

    public void createAlarmRecyclerView(){
        mRecyclerView = findViewById(R.id.Alarms_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new Alarms_Adapter(alarmList);


        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new Alarms_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                alarmList.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        });
    }

}