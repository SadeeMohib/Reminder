package com.example.reminderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditDataActivityMedicine extends AppCompatActivity {

    private static final String TAG = "EditDataActivityMedicine";

    private Button saveBtn, deleteBtn, doneBtn;
    private EditText editMedicineName;

    private String selectedName;
    private int selectedID;

    DataBaseHelper mDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_medication);
        deleteBtn = findViewById(R.id.deleteButton);
        editMedicineName = findViewById(R.id.edit_pill_name);
        mDataBaseHelper = new DataBaseHelper(this);

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        selectedName = receivedIntent.getStringExtra("name");
        editMedicineName.setText(selectedName);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataBaseHelper.deleteName(selectedID, selectedName);
                editMedicineName.setText("");
                toastMessage("removed from database");
                Intent intent = new Intent(EditDataActivityMedicine.this, AddMedication.class);
                startActivity(intent);
            }
        });

    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}