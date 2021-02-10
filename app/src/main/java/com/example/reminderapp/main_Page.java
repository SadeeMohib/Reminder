package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class main_Page extends AppCompatActivity {
    private ImageView medicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page);

        medicine = (ImageView) findViewById(R.id.medicine);


    }

    public void medica(View view) {
        Intent intent = new Intent(this,Medication.class);
        startActivity(intent);
    }
}