package com.home_wrokout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.home_wrokout.Alarm_RecyclerView.Alarm_activity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button12);
        plan=findViewById(R.id.button10);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlarm_activity();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openTreningiActivity();
            }
        });
    }
    public void openTreningiActivity(){
        Intent intent = new Intent(this, TreningiActivity.class);
        startActivity(intent);
    }
    public void openAlarm_activity(){
        Intent intent = new Intent(this, Alarm_activity.class);
        startActivity(intent);
    }
}