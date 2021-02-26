package com.example.reminderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteActionProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.reminderapp.UserAuth.User;

public class MyAccount extends AppCompatActivity {
    TextView name,email,age,gender,utype;
    Button update,del,Beck;
    FirebaseAuth mAth;
    FirebaseUser fUser;
    DatabaseReference fref;

    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        fUser=mAth.getInstance().getCurrentUser();
        uid=fUser.getUid();
        fref= FirebaseDatabase.getInstance().getReference();


        name=(TextView)findViewById(R.id.name);
        email=(TextView)findViewById(R.id.Email);
        age=(TextView)findViewById(R.id.age);
        gender=(TextView)findViewById(R.id.gender);
        utype=(TextView)findViewById(R.id.type);

        update=(Button)findViewById(R.id.updateAcc);
        del=(Button)findViewById(R.id.delAcc);
        Beck=(Button)findViewById(R.id.back);

        getData(fUser,uid,fref);
    }

    private void getData(FirebaseUser user,String id,DatabaseReference databaseReference) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String user_name=snapshot.child("Users").child(id).child("username").getValue(String.class);
                String user_age=snapshot.child("Users").child(id).child("age").getValue(String.class);
                String user_type=snapshot.child("Users").child(id).child("Usertype").getValue(String.class);
                String user_email=snapshot.child("Users").child(id).child("email").getValue(String.class);
                String user_gender=snapshot.child("Users").child(id).child("gender").getValue(String.class);

                name.setText(user_name);
                age.setText(user_age);
                utype.setText(user_type);
                email.setText(user_email);
                gender.setText(user_gender);
                Toast.makeText(MyAccount.this,"Success.",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MyAccount.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
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