package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Appoinment extends AppCompatActivity {

    Button set1,set2,cancel1,cancel2;
    TextView setTime,setDate;

    Calendar cal;
    int year1,month1,day;
    int hour,min,sec;
    long milisec;
    DateFormat dateFormat;
    String time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinment);

        set1=(Button)findViewById(R.id.setButton1);
        set2=(Button)findViewById(R.id.setButton2);
        cancel1=(Button)findViewById(R.id.cancelButton1);
        cancel2=(Button)findViewById(R.id.cancelButton2);

        setTime=(TextView)findViewById(R.id.time);
        setDate=(TextView)findViewById(R.id.date);
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(Appoinment.this,AddAppoinment.class));
    }

    public void setTime(View view) {
        Calendar cal2=Calendar.getInstance();
        int h=cal2.get(Calendar.HOUR_OF_DAY);
        int m=cal2.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hour=hourOfDay;
                min=minute;
                sec=0;
                Calendar newTime=Calendar.getInstance();
                newTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
                newTime.set(Calendar.MINUTE,minute);
                newTime.set(Calendar.SECOND,0);
                milisec=newTime.getTimeInMillis();
                time1=hour+":"+min+":"+sec;
                setTime.setText(time1);
            }
        },h,m,true);
        timePickerDialog.show();
    }

    public void setDat(View view) {
        cal=Calendar.getInstance();
        dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        DatePickerDialog GetDate=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate=Calendar.getInstance();
                newDate.set(year,month,dayOfMonth);
                setDate.setText(dateFormat.format(newDate.getTime()));
                day=dayOfMonth;
                year1=year;
                month1=month;
            }
        },cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
        GetDate.show();
    }

    public void removeDate(View view) {
        setDate.setText("");
    }

    public void removeTime(View view) {
        setTime.setText("");
    }

    public void setAppointment(View view) {
        if(setTime.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Time is empty!",Toast.LENGTH_LONG).show();
            return;
        }
        if(setDate.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Date is empty!",Toast.LENGTH_LONG).show();
            return;
        }

        String settle="Time="+time1+" "+day+" "+year1+" "+month1;
        Toast.makeText(this,settle,Toast.LENGTH_LONG).show();
    }


}
