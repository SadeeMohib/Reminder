package com.example.reminderapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminderapp.EmergencyCalling.Caller;
import com.example.reminderapp.EmergencyCalling.CallerAdapter;
import com.example.reminderapp.EmergencyCalling.ItemInfo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class MedicineList extends AppCompatActivity {

    ArrayList<ItemInfo> itemInfos=new ArrayList<>();
    RecyclerView rcl;
    RecyclerView.LayoutManager mlayoutManager;
    CallerAdapter mAdapter;
    DatabaseReference databaseReference;
    FirebaseUser fUser;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicinename);

        rcl=(RecyclerView)findViewById(R.id.rclview);
        fUser= FirebaseAuth.getInstance().getCurrentUser();
        uid=fUser.getUid();
        databaseReference= FirebaseDatabase.getInstance().getReference("Contacts/"+uid);

        getData(databaseReference,MedicineList.this);
    }

    ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int pos=viewHolder.getAdapterPosition();
            remove(itemInfos,pos,mAdapter);
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(MedicineList.this,R.color.orenge_red))
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    public void getData(DatabaseReference dbf, Context cnt)
    {
        dbf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dsp:snapshot.getChildren()) {
                    String nam = dsp.child("name1").getValue(String.class);
                    String num = dsp.child("num").getValue(String.class);
                    itemInfos.add(new ItemInfo(nam, num, R.drawable.ic_android,R.drawable.ic_baseline));
                }
                rcl.setHasFixedSize(true);
                mlayoutManager=new LinearLayoutManager(cnt);
                mAdapter=new CallerAdapter(itemInfos);
                rcl.setLayoutManager(mlayoutManager);
                rcl.setAdapter(mAdapter);

                mAdapter.setItemClickListener(new CallerAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(int pos) {
                        String getnum= itemInfos.get(pos).getNum();
                        Caller caller=new Caller();
                        caller.calluser(getnum,MedicineList.this);
                        //Toast.makeText(MainActivity.this,getnum,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void OnCallClick(int pos) {

                        //remove(itemInfos,pos,mAdapter);
                    }
                });
                ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
                itemTouchHelper.attachToRecyclerView(rcl);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(cnt,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void remove( ArrayList<ItemInfo> item,int pos,CallerAdapter adapter)
    {
        item.remove(pos);
        adapter.notifyItemRemoved(pos);
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
