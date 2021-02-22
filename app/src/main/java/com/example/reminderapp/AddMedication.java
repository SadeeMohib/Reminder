package com.example.reminderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AddMedication extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);
    }

    public void Medic(View view) {
        finish();
        startActivity(new Intent(AddMedication.this,Medication.class));
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(AddMedication.this,DashBoard.class));
    }
}
