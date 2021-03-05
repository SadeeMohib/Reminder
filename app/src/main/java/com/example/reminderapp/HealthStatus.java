package com.example.reminderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
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
    String age,gender;

    CardView BloodPressure,BmiCard,BmrCard,WeightCard,DiabetesCard;
    TextView bmi,bmr,bloodPress,weight,diabetes;
    Health health;

    double bmival,bmrval,heightval,weightval,systol,diastol,puls,diab;


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

                bmival=snapshot.child("HealthStatus").child(id).child("BMI").getValue(Double.class);
                bmrval=snapshot.child("HealthStatus").child(id).child("BMR").getValue(Double.class);
                weightval=snapshot.child("HealthStatus").child(id).child("weight").getValue(Double.class);
                diab=snapshot.child("HealthStatus").child(id).child("diabetes").getValue(Double.class);
                heightval=snapshot.child("HealthStatus").child(id).child("hight").getValue(Double.class);
                systol=snapshot.child("HealthStatus").child(id).child("bloodSystol").getValue(Double.class);
                diastol=snapshot.child("HealthStatus").child(id).child("bloodDiastol").getValue(Double.class);
                puls=snapshot.child("HealthStatus").child(id).child("pulse").getValue(Double.class);
                age=snapshot.child("Users").child(id).child("age").getValue(String.class);
                gender=snapshot.child("Users").child(id).child("gender").getValue(String.class);

                String bmi1=String.valueOf(bmival);
                String bmr1=String.valueOf(bmrval);
                String weight1=String.valueOf(weightval);
                String dia1=String.valueOf(diab);



                if(bmi1.equals("0.0") && bmr1.equals("0.0") && weight1.equals("0.0") && dia1.equals("0.0"))
                {
                    BmiCard.setCardBackgroundColor(Color.parseColor("#00bfff"));
                    BmrCard.setCardBackgroundColor(Color.parseColor("#00bfff"));
                    WeightCard.setCardBackgroundColor(Color.parseColor("#00bfff"));
                    DiabetesCard.setCardBackgroundColor(Color.parseColor("#00bfff"));

                }

                if(bmrval>0.0 && bmrval<=18.5)
                {
                    //underweight
                    BmrCard.setCardBackgroundColor(Color.parseColor("#00bfff"));
                }
                if(bmrval>18.5 && bmrval<=24.5)
                {
                    //normal weight
                    BmrCard.setCardBackgroundColor(Color.parseColor("#00FF7F"));
                }
                if(bmrval>24.5 && bmrval<=29.9)
                {
                    //over weight
                    BmrCard.setCardBackgroundColor(Color.parseColor("#ffff00"));
                }
                if(bmrval>29.9)
                {
                    //obese
                    BmrCard.setCardBackgroundColor(Color.parseColor("#FF4500"));
                }

                if(diab<=4.0)
                {
                    DiabetesCard.setCardBackgroundColor(Color.parseColor("#00bfff"));
                }

                if(diab>4.0 && diab<=6.0)
                {
                    DiabetesCard.setCardBackgroundColor(Color.parseColor("#00FF7F"));
                }
                if(diab>6.0)
                {
                    DiabetesCard.setCardBackgroundColor(Color.parseColor("#FF4500"));
                }

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
        Intent intent=new Intent(HealthStatus.this,HealthStatusUpdateActivity.class);
        intent.putExtra("Age",age);
        intent.putExtra("sex",gender);
        finish();
        startActivity(intent);

    }
}