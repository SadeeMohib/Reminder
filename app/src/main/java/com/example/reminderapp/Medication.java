package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Medication extends AppCompatActivity {

    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);
        text = (EditText)findViewById(R.id.pill_name);
        //System.out.println(text);
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(Medication.this,AddMedication.class));
    }
}