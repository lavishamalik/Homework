package com.codingblocks.mynotes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText et;

    String time;
    ArrayList<Notes> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.etNote);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        arrayList= loadArray(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        final NotesAdapter notesAdapter = new NotesAdapter(arrayList);
        recyclerView.setAdapter(notesAdapter);
        Button btnadd = findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = et.getText().toString();
                time = String.valueOf(System.currentTimeMillis());
                arrayList.add(new Notes(input, time));
                notesAdapter.notifyDataSetChanged();
                et.setText("");
            }
        });
    }

    @Override
    protected void onStop() {
        saveArray();
        super.onStop();
    }


    public void saveArray() {
        SharedPreferences sp = getSharedPreferences("my_pref", MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = sp.edit();

        mEdit1.putInt("Status_size", arrayList.size());

        for (int i = 0; i < arrayList.size(); i++) {
            mEdit1.putString("Note_Message" , String.valueOf(arrayList.get(i).getNote()));
            mEdit1.putString("Note_Time" , String.valueOf(arrayList.get(i).getTime()));
        }

        mEdit1.apply();
    }


    public ArrayList<Notes> loadArray(Context mContext) {

        ArrayList<Notes> notesArrayList =new ArrayList<>();
        SharedPreferences mSharedPreference1 = getSharedPreferences("my_pref", MODE_PRIVATE);
        arrayList.clear();
        int size = mSharedPreference1.getInt("Status_size", 0);

        for (int i = 0; i < size; i++) {
            String notes_mesg = mSharedPreference1.getString("Note_Message", null);
            String notes_time = mSharedPreference1.getString("Note_Time", null);

            notesArrayList.add(new Notes(notes_mesg, notes_time));


        }

        return notesArrayList;
    }

}
