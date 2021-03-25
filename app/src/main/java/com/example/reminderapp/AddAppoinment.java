package com.example.reminderapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminderapp.AlarmWorks.AppoinAdapter;
import com.example.reminderapp.AlarmWorks.AppoinDBHelper;
import com.example.reminderapp.AlarmWorks.AppoinItemInfo;

import java.util.ArrayList;

public class AddAppoinment extends AppCompatActivity {

    RecyclerView rcl2;
    RecyclerView.LayoutManager mlayout;

    AppoinDBHelper myDB;
    Cursor cursor;

    AppoinAdapter appoinAdapter;
    ArrayList<AppoinItemInfo> appoinItemInfos=new ArrayList<>();
    ArrayList<Integer> appoinID=new ArrayList<>();
    String docName;
    String desc;
    String readableTime;
    String Date;
    String status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appoinment);

        rcl2=(RecyclerView)findViewById(R.id.rcl2);

        myDB=new AppoinDBHelper(AddAppoinment.this);
        storeDataInArrays(AddAppoinment.this);
    }

    public void storeDataInArrays(Context context)
    {
        cursor=myDB.getAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(AddAppoinment.this,"No data in database",Toast.LENGTH_LONG).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                appoinID.add(cursor.getInt(0));
                int id=cursor.getInt(0);
                docName=cursor.getString(1);
                desc=cursor.getString(2);
                readableTime=cursor.getString(4);
                Date=cursor.getString(5);
                status=cursor.getString(6);
                appoinItemInfos.add(new AppoinItemInfo(docName,desc,readableTime,Date,status,id,R.drawable.ic_outline_medical_services_24));
            }

            rcl2.setHasFixedSize(true);
            mlayout=new LinearLayoutManager(context);
            appoinAdapter=new AppoinAdapter(appoinItemInfos);
            rcl2.setLayoutManager(mlayout);
            rcl2.setAdapter(appoinAdapter);

        }
    }

    public void Appoin(View view) {
        finish();
        startActivity(new Intent(AddAppoinment.this,Appoinment.class));
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(AddAppoinment.this,DashBoard.class));
    }
}
