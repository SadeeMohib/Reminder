package com.example.reminderapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddMedication extends AppCompatActivity {

    private static final String TAG = "AddMedication";

    DataBaseHelper mDataBaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);
        mListView = findViewById(R.id.medicineList);
        mDataBaseHelper = new DataBaseHelper(this);
        populateListView();
    }

    private void populateListView() {
        Cursor data = mDataBaseHelper.getData();
        //ArrayList<HashMap<String,String>> listData = new ArrayList<>();
        ArrayList<String> listData = new ArrayList<>();
        String titleArray = null;
        String subItemArray = null;
        while(data.moveToNext()) {
            //HashMap<String,String> datum = new HashMap<>();
            //datum.put("Medicine Name", titleArray);
            //datum.put("Time", subItemArray);
            listData.add(data.getString(1));
            //listData.add(timeData.getString(2));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_remind_medicine_format, R.id.title, listData);

        //SimpleAdapter adapter = new SimpleAdapter(this, listData, android.R.layout.simple_list_item_2, new String[] {"Medicine Name", "Time"}, new int[] {R.id.pill_name, R.id.timePicker});
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = adapterView.getItemAtPosition(position).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDataBaseHelper.getItemID(name);
                int itemID = -1;
                while(data.moveToNext()) {
                    itemID = data.getInt(0);
                }
                if(itemID > -1) {
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    Intent editScreenIntent = new Intent(AddMedication.this, EditDataActivityMedicine.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);
                    startActivity(editScreenIntent);
                }
                else
                    toastMessage("No ID associated with that name");
            }
        });

    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void Medic(View view) {
        finish();
        startActivity(new Intent(AddMedication.this,Medication.class));
    }

    public void back(View view) {
        finish();
        startActivity(new Intent(AddMedication.this,DashBoard.class));
    }
}
