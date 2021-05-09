package com.home_wrokout.Alarm_RecyclerView;

public class RecyclerView_Item {

    private String time;
    private String days_of_week;
    private int hour;
    private int minute;

    public RecyclerView_Item(String days_of_week, int hour, int minute){
        if ( minute < 10 )
            this.time = hour+":"+minute+"0";
        else
            this.time = hour+":"+minute;
        this.hour = hour;
        this.minute = hour;
        this.days_of_week = days_of_week;
    }

    public String getTime() {
        return time;
    }

    public String getDays_of_week() {
        return days_of_week;
    }
}
