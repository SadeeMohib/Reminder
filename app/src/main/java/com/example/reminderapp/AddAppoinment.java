package com.example.reminderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AddAppoinment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appoinment);
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
