package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class HealthStatusUpdateActivity extends AppCompatActivity {
    EditText sys,diastole,heightFeet,heightInch,pulse,weight,diabetes;
    TextView bmi,bmr,heightMeter;

    FirebaseUser user;
    DatabaseReference dbf;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status_update);

        sys=(EditText)findViewById(R.id.systol);
        diastole=(EditText)findViewById(R.id.diastol);
        heightFeet=(EditText)findViewById(R.id.heightFeet);
        heightInch=(EditText)findViewById(R.id.heightInch);
        pulse=(EditText)findViewById(R.id.pulse);
        diabetes=(EditText)findViewById(R.id.diabetes);
        weight=(EditText)findViewById(R.id.weight);

        heightMeter=(TextView)findViewById(R.id.inmete);
        bmi=(TextView)findViewById(R.id.bmi);
        bmr=(TextView)findViewById(R.id.bmr);
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(HealthStatusUpdateActivity.this,DashBoard.class));
    }

    public void update(View view) {

    }
}