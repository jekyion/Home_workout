package com.home_wrokout.Alarm_RecyclerView;

import android.app.AlarmManager;
import android.content.Context;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class AlarmManagerTableInstanceCreator implements InstanceCreator<AlarmManager> {

    private Context context;

    public AlarmManagerTableInstanceCreator(Context context) {
        this.context = context;
    }

    @Override
    public AlarmManager createInstance(Type type) {
        return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }
}
