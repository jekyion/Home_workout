package com.home_wrokout.Alarm_RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.home_wrokout.R;

public class Alarm_add_activity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private int hour;
    private int minute;
    private int position;

    private String EXTRA_POSITION = "EXTRA_POSITION";
    private String EXTRA_HOUR = "EXTRA_HOUR";
    private String EXTRA_MINUTE = "EXTRA_MINUTE";
    private String EXTRA_DAYSOFWEEK = "EXTRA_DAYSOFWEEK";
//    private String EXTRA_DOSETALARM = "EXTRA_DOSETALARM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_add);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                position = -1;
            } else {
                position = extras.getInt(EXTRA_POSITION);
            }
        } else {
            position = (Integer) savedInstanceState.getSerializable(EXTRA_POSITION);
        }

        hour = -1;
        minute = -1;

        Button button_Ustaw = findViewById(R.id.button_Ustaw);
        button_Ustaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendAlarmData();
            }
        });

        Button button_timePicker = findViewById(R.id.button_chose_time);
        button_timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePicker_class();
                timePicker.show(getSupportFragmentManager(), "Wybierz date");
            }
        });

    }

    private void SendAlarmData() {
        Intent intent = new Intent(Alarm_add_activity.this, Alarm_activity.class);
        String string_Days = CheckDaysOFWeek();
        if( position == -1 || hour == -1 || minute == -1 || string_Days == ""){
            Toast.makeText(getApplicationContext(), "uzupełnij dane", Toast.LENGTH_SHORT);
        } else
            intent.putExtra(EXTRA_POSITION, position);
            intent.putExtra(EXTRA_HOUR, hour);
            intent.putExtra(EXTRA_MINUTE, minute);
            intent.putExtra(EXTRA_DAYSOFWEEK, string_Days);
//            intent.putExtra(EXTRA_DOSETALARM, true);
            startActivity(intent);
    }

    private String CheckDaysOFWeek(){
        CheckBox pon = findViewById(R.id.checkBox_pon);
        CheckBox wt = findViewById(R.id.checkBox_wt);
        CheckBox sr = findViewById(R.id.checkBox_sr);
        CheckBox czw = findViewById(R.id.checkBox_czw);
        CheckBox ptk = findViewById(R.id.checkBox_ptk);
        CheckBox sob = findViewById(R.id.checkBox_sob);
        CheckBox nd = findViewById(R.id.checkBox_nd);
        String[] Tab = {"pon","wt","sr","czw","ptk","sob","nd"};
        CheckBox[] checkBoxes = {pon, wt, sr, czw, ptk, sob, nd};
        String result = "";

        for( int i = 0; i < checkBoxes.length; i++ )
            if( checkBoxes[i].isChecked() == true)
                result += Tab[i]+", ";

        if( result != "")
            result = result.substring(0, result.length() - 2);
        return result;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView = findViewById(R.id.textView_godzina);
        if ( minute < 10 )
            textView.setText(hourOfDay+":0"+minute);
        else
            textView.setText(hourOfDay+":"+minute);
        this.hour = hourOfDay;
        this.minute = minute;
    }

}