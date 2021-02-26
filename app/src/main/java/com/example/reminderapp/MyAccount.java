package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteActionProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyAccount extends AppCompatActivity {
    TextView name,email,age,gender,utype;
    Button update,del,Beck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        name=(TextView)findViewById(R.id.name);
        email=(TextView)findViewById(R.id.Email);
        age=(TextView)findViewById(R.id.age);
        gender=(TextView)findViewById(R.id.gender);
        utype=(TextView)findViewById(R.id.type);

        update=(Button)findViewById(R.id.updateAcc);
        del=(Button)findViewById(R.id.delAcc);
        Beck=(Button)findViewById(R.id.back);
    }

    public void Update(View view) {
    }

    public void Delete(View view) {
    }

    public void GoBack(View view) {
        finish();
        startActivity(new Intent(MyAccount.this,DashBoard.class));
    }
}