package com.home_wrokout.Alarm_RecyclerView;

import java.util.ArrayList;

public class Alarm_ItemCollector {

    private ArrayList<RecyclerView_Item> list;

    Alarm_ItemCollector(){
        list = new ArrayList<RecyclerView_Item>();
    }

    public void add(RecyclerView_Item item){
        list.add(item);
    }

    public void remove(int position){
        list.remove(position);
    }

    public ArrayList<RecyclerView_Item> getList() {
        return list;
    }
}
