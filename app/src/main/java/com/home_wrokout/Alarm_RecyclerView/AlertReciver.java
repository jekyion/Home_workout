package com.home_wrokout.Alarm_RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;

import com.home_wrokout.R;

import java.util.ArrayList;
import java.util.Calendar;

public class AlertReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            ;
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = (NotificationManager) context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        System.out.println("XD");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "My Notification");
        builder.setContentTitle("Home workout");
        builder.setContentText("Pora ćwiczyć!");
        builder.setSmallIcon(R.drawable.fire);
        builder.setAutoCancel(true);

        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        manager.notify(1, builder.build());

    }

//    AlertReciver(){
//        alarmCollection = new TableCollectionAlarmManager();
//    }
//
//    public ArrayList<Integer> setAlarm(Context context, ArrayList<Calendar> calendars)
//    {
//        System.out.println("xd");
//        ArrayList<Integer> takenIndexList = new ArrayList<>();
//        for ( Calendar calendar: calendars ) {
//            int index = alarmCollection.getIndeks();
//            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//            Intent intent = new Intent(context, AlertReciver.class);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, index, intent, 0);
////            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
////                    24 * 60 * 60 * 1000, pendingIntent);
//            alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + (1000*3) , pendingIntent);
//            takenIndexList.add(index);
//            alarmCollection.add(alarmManager);
//        }
//        System.out.println("XD tutaj dotarłem"+takenIndexList);
//        return takenIndexList;
//    }
//
//    public void deleteAlarm(Context context, ArrayList<Integer> takenIndexList){
//        stopAlarms(context, takenIndexList);
//        for ( int index: takenIndexList){
//            alarmCollection.delete(index);
//        }
//    }
//
//    public void stopAlarms(Context context, ArrayList<Integer> takenIndexList){
//        for ( int index: takenIndexList ){
//            Intent intent = new Intent(context, AlertReciver.class);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, index, intent, 0);
//            alarmCollection.getFromIndex(index).cancel(pendingIntent);
//        }
//    }
//
//    public void cancelAlarm(Context context)
//    {
//        Intent intent = new Intent(context, AlertReciver.class);
//        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        alarmManager.cancel(sender);
//    }

}
