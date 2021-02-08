package com.example.reminderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
        String email=user_email.getText().toString().trim();
        String pass=user_password.getText().toString().trim();

        if(email.isEmpty())
        {
            user_email.setError("Email Required");
            user_email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            user_email.setError("Valid Email Address Required");
            user_email.requestFocus();
            return;
        }

        if(pass.isEmpty())
        {
            user_password.setError("Password required");
            user_password.requestFocus();
            return;
        }

        if(pass.length()<6)
        {
            user_password.setError("Minimum Password length is 6");
            user_password.requestFocus();
            return;
        }

        Intent intent=new Intent(this, DashBoard.class);
        //Login function firebase
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        finish();
                        startActivity(intent);
                        Toast.makeText(DataBaseActivity.this,"Logged In",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(DataBaseActivity.this,"Failed to login. Please check your credentials",Toast.LENGTH_LONG).show();
                    }
            }
        });

    }

    public void CreateAcc(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        finish();
        startActivity(intent);
    }
}