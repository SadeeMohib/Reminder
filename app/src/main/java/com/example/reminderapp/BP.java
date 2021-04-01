package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BP extends AppCompatActivity {
    FirebaseUser user;
    DatabaseReference databaseReference;
    String uid;
    String systole,diastole,pulse;
    TextView syst,diast,Condition;
    PhotoView photoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_p);

        syst=(TextView)findViewById(R.id.sys);
        diast=(TextView)findViewById(R.id.dias);
        Condition=(TextView)findViewById(R.id.condition);

        Intent intent=getIntent();
        systole=intent.getStringExtra("sys");
        diastole=intent.getStringExtra("dias");
        pulse=intent.getStringExtra("Pulse");

        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();

        databaseReference= FirebaseDatabase.getInstance().getReference();

        syst.setText(systole);
        diast.setText(diastole);


        PhotoView photoView = (PhotoView) findViewById(R.id.catchart);
        photoView.setImageResource(R.drawable.bpstageii);

        

    }

    public void goDocList(View view) {
        Intent intent=new Intent(BP.this,DoctListActivity.class);
        intent.putExtra("typ","Cardiac");
        finish();
        startActivity(intent);
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(BP.this,HealthStatus.class));
    }
}