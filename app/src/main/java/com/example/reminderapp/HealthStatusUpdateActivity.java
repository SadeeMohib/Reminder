package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reminderapp.calculators.HeightConvert;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;

public class HealthStatusUpdateActivity extends AppCompatActivity {
    EditText sys,diastole,heightFeet,heightInch,pulse,weight,diabetes;
    TextView bmi,bmr,heightMeter;
    double weigh,bmi1,bmr1,height1,sys1,dias,pul,diab1,height2,heightMe;

    FirebaseUser user;
    DatabaseReference dbf;
    String uid;
    HeightConvert heightConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status_update);

        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        dbf= FirebaseDatabase.getInstance().getReference();

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

        heightConvert=new HeightConvert();

    }

    public void back(View view) {
        finish();
        startActivity(new Intent(HealthStatusUpdateActivity.this,DashBoard.class));
    }

    public void update(View view) {
            if(sys.getText().toString().isEmpty())
            {
                sys.setError("Systole Required");
                sys.requestFocus();
                return;
            }

            if(diastole.getText().toString().isEmpty())
            {
                diastole.setError("Diastole Required");
                diastole.requestFocus();
                return;
            }

            if(heightFeet.getText().toString().isEmpty())
            {
                heightFeet.setError("Height Required");
                heightFeet.requestFocus();
                return;
            }

            if(heightInch.getText().toString().isEmpty())
            {
                heightInch.setError("Height Required");
                heightInch.requestFocus();
                return;
            }

            if(pulse.getText().toString().isEmpty())
            {
                pulse.setError("Heart Pulse required.Your pulse rate can be found on your prescription");
                pulse.requestFocus();
                return;
            }

            if(diabetes.getText().toString().isEmpty())
            {
                diabetes.setError("Diabetes required");
                diabetes.requestFocus();
                return;
            }

            if(weight.getText().toString().isEmpty())
            {
                weight.setError("Weight required");
                weight.requestFocus();
                return;
            }

            try {
                weigh=Double.parseDouble(weight.getText().toString());
                sys1=Double.parseDouble(sys.getText().toString());
                dias=Double.parseDouble(diastole.getText().toString());
                pul=Double.parseDouble(pulse.getText().toString());
                diab1=Double.parseDouble(diabetes.getText().toString());
                height1=Double.parseDouble(heightFeet.getText().toString());
                height2=Double.parseDouble(heightInch.getText().toString());
                //bmi1=Double.parseDouble(bmi.getText().toString());
                //bmr1=Double.parseDouble(bmr.getText().toString());

                heightMe=heightConvert.convertToMeter(height2,height1);


            }catch (NumberFormatException e)
            {
                Toast.makeText(HealthStatusUpdateActivity.this,"Inputs must be numbers",Toast.LENGTH_LONG).show();
            }
            heightMeter.setText(String.valueOf(heightMe));
    }


}