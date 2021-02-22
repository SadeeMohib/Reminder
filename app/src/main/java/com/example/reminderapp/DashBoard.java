package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class DashBoard extends AppCompatActivity {
    Button logout;
    ImageView addMedica;
    ImageView addAppoinment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //logout=(Button)findViewById(R.id.log_out);
        addMedica=(ImageView)findViewById(R.id.medicine);
        addAppoinment=(ImageView)findViewById(R.id.Appointment);
    }




    public void LogOut(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(DashBoard.this,DataBaseActivity.class));
    }

    public void Add_medicine(View view) {

    }

    public void addMedic(View view) {
        finish();
        startActivity(new Intent(DashBoard.this,AddMedication.class));
    }

    public void appoin(View view) {
        finish();
        startActivity(new Intent(DashBoard.this,AddAppoinment.class));
    }
}