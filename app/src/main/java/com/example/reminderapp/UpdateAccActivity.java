package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateAccActivity extends AppCompatActivity {
    EditText name,email,age,gender,pass;

    String user_name;
    String user_age;
    String user_type;
    String user_email;
    String user_gender;
    String user_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_acc);

        Intent intent=getIntent();
        user_name=intent.getStringExtra("name");
        user_age=intent.getStringExtra("age");
        user_email=intent.getStringExtra("email");
        user_gender=intent.getStringExtra("gender");
        user_password=intent.getStringExtra("pas");

        name=(EditText) findViewById(R.id.name);
        email=(EditText)findViewById(R.id.Email);
        age=(EditText)findViewById(R.id.age);
        gender=(EditText)findViewById(R.id.gender);
        pass=(EditText)findViewById(R.id.pass);

        name.setText(user_name);
        age.setText(user_age);
        email.setText(user_email);
        gender.setText(user_gender);
        pass.setText(user_password);
    }

    public void Back(View view) {
        finish();
        startActivity(new Intent(UpdateAccActivity.this,MyAccount.class));

    }

    public void Updater(View view) {

    }
}