package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class DashBoard extends AppCompatActivity {
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        logout=(Button)findViewById(R.id.log_out);
    }

    public void LogOut(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(DashBoard.this,DataBaseActivity.class));
    }
}