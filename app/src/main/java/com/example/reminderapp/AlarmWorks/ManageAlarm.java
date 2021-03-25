package com.example.reminderapp.AlarmWorks;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.reminderapp.Alarm;

import java.util.Calendar;
import java.util.Random;

public class ManageAlarm {
    int hour,min;
    int year,month,day;
    long miliTime;

    public ManageAlarm()
    {

    }

    public ManageAlarm(int hour,int min,int year,int month,int day)
    {
        this.hour=hour;
        this.min=min;
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public void AppoinmentAlarm(int requestCode,int hour, int min, int year, int month, int day, Context context)
    {
        Calendar setCal=Calendar.getInstance();
        setCal.set(year,month,day,hour-3,min);
        miliTime=setCal.getTimeInMillis();

        Intent alarmIntent=new Intent(context,BroadCaster.class);
        AlarmManager alarmManager=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,requestCode,alarmIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP,miliTime,pendingIntent);

        Toast.makeText(context,"Appointment Reminder set",Toast.LENGTH_SHORT).show();
    }
}
