package com.home_wrokout.Alarm_RecyclerView;

public class RecyclerView_Item {

    private String hour;
    private String days_of_week;

    public RecyclerView_Item(String hour, String days_of_week){
        this.hour = hour;
        this.days_of_week = days_of_week;
    }

    public String getHour() {
        return hour;
    }

    public String getDays_of_week() {
        return days_of_week;
    }
}
