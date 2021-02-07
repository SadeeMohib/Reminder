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

import com.example.reminderapp.UserAuth.User;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.intellij.lang.annotations.Pattern;

public class RegisterActivity extends AppCompatActivity {
    TextView txt1;
    EditText userName,email,age,gender,weight,password;
    Button cancel,signUp;

    String user_name,Email,Gender,Weight,Password,Age;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt1=(TextView)findViewById(R.id.reg);

        userName=(EditText)findViewById(R.id.user_name);
        email=(EditText)findViewById(R.id.new_email);
        age=(EditText)findViewById(R.id.age_user);
        gender=(EditText)findViewById(R.id.gender);
        weight=(EditText)findViewById(R.id.weight);
        password=(EditText)findViewById(R.id.new_password);

        cancel=(Button)findViewById(R.id.cancel_button) ;
        signUp=(Button)findViewById(R.id.sign_up);

        mAuth=FirebaseAuth.getInstance();
    }

    public void SignUp(View view) {
        user_name=userName.getText().toString().trim();
        Email=email.getText().toString().trim();
        Gender=gender.getText().toString().trim();
        Weight=weight.getText().toString().trim();
        Age=age.getText().toString().trim();
        Password=password.getText().toString();

        if(user_name.isEmpty())
        {
            userName.setError("Name Required");
            userName.requestFocus();
            return;
        }

        if(Age.isEmpty())
        {
            age.setError("Age Required");
            age.requestFocus();
            return;
        }
        if(Email.isEmpty())
        {
            email.setError("Email Required");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            email.setError("Valid email needed");
            email.requestFocus();
            return;
        }
        if(Password.isEmpty())
        {
            password.setError("Password Required");
            password.requestFocus();
            return;
        }

        if(Gender.isEmpty())
        {
            gender.setError("Gender Required (Male/Female)");
            gender.requestFocus();
            return;
        }
        /*
        if(!Gender.equals("Male"))
        {
            gender.setError("Valid Gender(Male/Female) Required");
            gender.requestFocus();
            return;
        }
        if(!Gender.equals("Female"))
        {
            gender.setError("Valid Gender(Male/Female) Required");
            gender.requestFocus();
            return;
        }
        */
        if(Weight.isEmpty())
        {
            weight.setError("Weight(Kg) Required");
            weight.requestFocus();
            return;
        }

        //Authenticating the user to firebase....Firebase e user er info raktesi account khultesi
        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            User user=new User(user_name,Email,Age,Weight,Gender,Password);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(RegisterActivity.this,"Account Created!",Toast.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(RegisterActivity.this,"Failed to create an account",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,"Failed to create an account",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void Cancel(View view) {
        Intent intent=new Intent(this,DataBaseActivity.class);
        finish();
        startActivity(intent);
    }
}