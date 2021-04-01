package com.example.reminderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Weight extends AppCompatActivity {
    PhotoView photoview;
    TextView cat,weight_,height_,age1;
    FirebaseUser user;
    DatabaseReference databaseReference;
    String uid,age2,gender;
    double heightval,weightval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);


        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();

        databaseReference= FirebaseDatabase.getInstance().getReference();

        age1= (TextView) findViewById(R.id.Age);
        weight_=(TextView)findViewById(R.id.weight);
        height_=(TextView)findViewById(R.id.height);

        getData(databaseReference,uid);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.weightchart);
    }



    private void getData(DatabaseReference dbf,String id) {

        dbf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                weightval=snapshot.child("HealthStatus").child(id).child("weight").getValue(Double.class);
                age2 = snapshot.child("Users").child(id).child("age").getValue(String.class);
                heightval = snapshot.child("HealthStatus").child(id).child("hight").getValue(Double.class);
                gender = snapshot.child("Users").child(id).child("gender").getValue(String.class);
             

                String weight1 = String.valueOf(weightval);
                String height1 = String.valueOf(heightval);
                weight_.setText(weight1);
                height_.setText(height1);
                age1.setText(age2);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Weight.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });



    }



        public void back(View view) {
        finish();
        startActivity(new Intent(Weight.this,HealthStatus.class));
    }

    public void goDocList(View view) {
    }
}