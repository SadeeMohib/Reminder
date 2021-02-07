package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataBaseActivity extends AppCompatActivity {
    private EditText user_name, password_view;
    private TextView  reg_button;
    private Button button_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user_name = (EditText)findViewById(R.id.user_name);

        password_view = (EditText)findViewById(R.id.password_view);

        button_login = (Button) findViewById(R.id.button_login);
        reg_button =(TextView) findViewById(R.id.reg_button);

        setContentView(R.layout.activity_data_base);
    }

    public void Login(View view) {


    }
}