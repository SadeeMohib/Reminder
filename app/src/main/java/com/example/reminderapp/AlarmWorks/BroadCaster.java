package com.example.reminderapp.AlarmWorks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.reminderapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BroadCaster extends BroadcastReceiver {

    private static final String channelID="channelID";
    private static final String channelName="Appointment Channel";
    DateFormat dateFormat;


    @Override
    public void onReceive(Context context, Intent intent) {

        dateFormat=new SimpleDateFormat("dd/MM/yyyy");

        AppoinDBHelper myDB=new AppoinDBHelper(context);
        Cursor cursor;
        int ID=intent.getExtras().getInt("reqCode");

        Calendar calendar=Calendar.getInstance();
        int h=calendar.get(Calendar.HOUR_OF_DAY);
        int m=calendar.get(Calendar.MINUTE);

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);

        calendar.set(year,month,day);
        String date=dateFormat.format(calendar.getTime());

        String docName="";
        String time=String.valueOf(h)+":"+String.valueOf(m)+"0";
        cursor=myDB.getCurrentAppointment(ID);
        int docIndex=cursor.getColumnIndex("DocName");

        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(cursor!=null && cursor.moveToFirst())
        {
            docName=cursor.getString(docIndex);
            cursor.close();
        }

        String messege="You have an appointment with "+docName+" at "+date;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel=new NotificationChannel(channelID,channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,channelID)
                                                .setSmallIcon(R.drawable.ic_baseline_medical_services_24)
                                                .setContentTitle("Doctor Appointment")
                                                .setContentText(messege)
                                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                                .setAutoCancel(true);
        notificationManager.notify(2,builder.build());
    }
}
