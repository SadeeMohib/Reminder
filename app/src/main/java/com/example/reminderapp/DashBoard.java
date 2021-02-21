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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //logout=(Button)findViewById(R.id.log_out);
        addMedica=(ImageView)findViewById(R.id.medicine);
    }



    public void LogOut(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(DashBoard.this,DataBaseActivity.class));
    }

    public void Add_medicine(View view) {

    }

    public void Medic(View view) {
        finish();
        startActivity(new Intent(DashBoard.this,Medication.class));
    }
}