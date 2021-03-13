package com.example.reminderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reminderapp.EmergencyCalling.ItemInfo;

import java.util.ArrayList;

public class MedicineList extends AppCompatActivity {
    Button save;
    ArrayList<ItemInfo> itemInfos=new ArrayList<>();
    EditText txt;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicinename);

    }

    public void back(View view) {
        finish();
        startActivity(new Intent(MedicineList.this,DashBoard.class));
    }

    public void adder(View view) {
        finish();
        startActivity(new Intent(MedicineList.this,AddCallerActivity.class));
    }
}
