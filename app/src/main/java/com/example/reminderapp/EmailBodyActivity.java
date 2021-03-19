package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.reminderapp.EmergencyCalling.SendMail;

public class EmailBodyActivity extends AppCompatActivity {
    EditText reciver;
    EditText subj;
    EditText messagebody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_body);

        Intent intent=getIntent();

        reciver=(EditText)findViewById(R.id.to);
        subj=(EditText)findViewById(R.id.subject);
        messagebody=(EditText)findViewById(R.id.message);

        String re=intent.getStringExtra("mail");
        reciver.setText(re);
    }



    public void back(View view) {
        finish();
        startActivity(new Intent(EmailBodyActivity.this,MedicineList.class));
    }

    public void send(View view) {
        SendMail sendMail=new SendMail();

        String rec=reciver.getText().toString();
        String sub=subj.getText().toString();
        String mes=messagebody.getText().toString();

        if(rec.isEmpty())
        {
            reciver.setError("Receiver email address required");
            reciver.requestFocus();
            return;
        }

        sendMail.Send(rec,sub,mes,EmailBodyActivity.this);
    }
}