package com.example.reminderapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MedicineList extends AppCompatActivity {
    Button save;
    ArrayList<String> medicineName = new ArrayList<>();
    EditText txt;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicinename);
        txt = (EditText) findViewById(R.id.listOfMedicine);
        show = (ListView) findViewById(R.id.medicineList);
        save = (Button) findViewById(R.id.saveMedicineName);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

                if (medicineName.contains(getInput)) {
                    Toast.makeText(getBaseContext(), "Item exits", Toast.LENGTH_LONG).show();
                }
                else if (getInput == null || getInput.trim().equals(" ")) {
                    Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_LONG).show();
                }
                else {
                    medicineName.add(getInput);
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MedicineList.this, android.R.layout.simple_list_item_1, medicineName);
                    show.setAdapter(arrayAdapter);
                    ((EditText) findViewById(R.id.listOfMedicine)).setText(" ");
                }
            }
        });

    }
}
