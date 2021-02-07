package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class DataBaseActivity extends AppCompatActivity {
    TextView txt,Register;
    EditText user_email,user_password;
    Button LogIn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        txt=(TextView)findViewById(R.id.text_userinfo);
        Register=(TextView)findViewById(R.id.reg_button);

        user_email=(EditText)findViewById(R.id.user_name);
        user_password=(EditText)findViewById(R.id.password_view);

        LogIn=(Button)findViewById(R.id.button_login);

        mAuth=FirebaseAuth.getInstance();
    }

    public void Login(View view) {
    }

    public void CreateAcc(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        finish();
        startActivity(intent);
    }
}