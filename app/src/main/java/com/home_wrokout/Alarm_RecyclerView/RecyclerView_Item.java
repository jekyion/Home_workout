package com.home_wrokout.Alarm_RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class RecyclerView_Item {

    private String time;
    private String days_of_week;
    private int hour;
    private int minute;
    private Boolean isOn;
    private ArrayList<Integer> takenSlots;

    public RecyclerView_Item(String days_of_week, int hour, int minute){
        if ( minute < 10 )
            this.time = hour+":0"+minute;
        else
            this.time = hour+":"+minute;
        this.hour = hour;
        this.minute = minute;
        this.days_of_week = days_of_week;
        isOn = false;
    }

    public String getTime() {
        return time;
    }

    public String getDays_of_week() {
        return days_of_week;
    }

    public ArrayList<Calendar> getCalendars(){
        ArrayList<Calendar> calendarArrayList = new ArrayList<>();

        String[] Tab = {"nd", "pon", "wt", "sr", "czw", "ptk", "sob"};
        String string = days_of_week.replaceAll("\\s+","");
        String[] splitedString = string.split(",");

        for ( String day: splitedString ){

            int index = -1;
            for (int i = 0 ; i < Tab.length ; i++) {
                if (Tab[i].equals(day)) {
                    index = i+1;
                    break;
                }
            }

            Calendar calendar = Calendar.getInstance();
            if( index == -1 ) throw new IndexOutOfBoundsException();
            calendar.set(Calendar.DAY_OF_WEEK, index);
            calendar.set(Calendar.MINUTE, this.minute);
            calendar.set(Calendar.HOUR_OF_DAY, this.hour);
            calendar.set(Calendar.SECOND, 0);

            calendarArrayList.add(calendar);
        }
        return calendarArrayList;
    }

    public void setTakenSlots(ArrayList<Integer> takenSlots) {
        this.takenSlots = takenSlots;
    }

    public ArrayList<Integer> getTakenSlots() {
        return takenSlots;
    }

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
