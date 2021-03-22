package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;
public class Medication extends AppCompatActivity {

    DataBaseHelper mDatabaseHelper;
    private int notiId = 1;
    private Button setBtn, cancelBtn;
    private EditText medicineName;
    private TimePicker timePicker;
    Calendar calendar;
    int reqCode = 1;
    private NotificationManagerCompat notificationManager;

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);
        setBtn = findViewById(R.id.setButton);
        cancelBtn = findViewById(R.id.cancelButton);
        medicineName = findViewById(R.id.pill_name);
        timePicker = findViewById(R.id.timePicker);
        mDatabaseHelper = new DataBaseHelper(this);
        notificationManager = NotificationManagerCompat.from(this);

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = medicineName.getText().toString();
                Intent intentAlarm = new Intent(Medication.this, Alarm.class);
                int random = rand.nextInt(100);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(Medication.this, random, intentAlarm, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                if (medicineName.length() != 0) {
                    int hour = timePicker.getCurrentHour();
                    int min = timePicker.getCurrentMinute();
                    calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, hour);
                    calendar.set(Calendar.MINUTE, min);
                    calendar.set(Calendar.SECOND, 0);
                    long alarmStartTime = calendar.getTimeInMillis();
                    alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
                    String time = " - " + hour + " : " + min + " : " + "00";
                    AddData(newEntry);
                    //addTime(time);
                    medicineName.setText("");
                    Intent intent = new Intent(Medication.this, AddMedication.class);
                    startActivity(intent);
                } else
                    toastMessage("You must put something in the text field!");
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Medication.this, AddMedication.class);
                startActivity(intent);
            }
        });
    }

    private void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if(insertData)
            toastMessage("Data Successfully Inserted!");
        else toastMessage("Something went wrong");
    }

    private void addTime(String time) {
        boolean insertData = mDatabaseHelper.addData(time);
        if(insertData)
            toastMessage("Data Successfully Inserted!");
        else toastMessage("Something went wrong");
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(Medication.this,AddMedication.class));
    }
}