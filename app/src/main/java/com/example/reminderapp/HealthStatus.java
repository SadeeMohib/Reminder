package com.example.reminderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.reminderapp.UserAuth.Health;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HealthStatus extends AppCompatActivity {

    FirebaseUser user;
    DatabaseReference databaseReference;
    String uid;


    CardView BloodPressure,BmiCard,BmrCard,WeightCard,DiabetesCard;
    TextView bmi,bmr,bloodPress,weight,diabetes;
    Health health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_status);

        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();

        databaseReference= FirebaseDatabase.getInstance().getReference();

        BmiCard=(CardView)findViewById(R.id.BMIcard);
        BmrCard=(CardView)findViewById(R.id.BMRCard);
        WeightCard=(CardView)findViewById(R.id.WeightCard);
        DiabetesCard=(CardView)findViewById(R.id.DiabetesCard);

        bmi=(TextView)findViewById(R.id.bmi);
        bmr=(TextView)findViewById(R.id.bmr);
        weight=(TextView)findViewById(R.id.weight);
        diabetes=(TextView)findViewById(R.id.diabetes);
        bloodPress=(TextView)findViewById(R.id.bloodPressur);

        getData(databaseReference,uid);



    }

    private void getData(DatabaseReference dbf,String id) {

        dbf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String bmi1=String.valueOf(snapshot.child("HealthStatus").child(id).child("BMI").getValue(Double.class));
                String bmr1=String.valueOf(snapshot.child("HealthStatus").child(id).child("BMR").getValue(Double.class));
                String weight1=String.valueOf(snapshot.child("HealthStatus").child(id).child("weight").getValue(Double.class));
                String dia1=String.valueOf(snapshot.child("HealthStatus").child(id).child("diabetes").getValue(Double.class));

                bmi.setText(bmi1);
                bmr.setText(bmr1);
                weight.setText(weight1);
                diabetes.setText(dia1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(HealthStatus.this,DashBoard.class));

    }
}