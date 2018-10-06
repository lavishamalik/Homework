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

        arrayList=loadArray(this);

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
        super.onStop();
        saveArray();
    }

    private void saveArray() {
        SharedPreferences sharedPreferences=getSharedPreferences("Mypref",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("SIZE",arrayList.size());
        for(int i=0;i<arrayList.size();i++)
        {
            editor.putString("NOTES",arrayList.get(i).getNote());
            editor.putString("TIME",arrayList.get(i).getTime());
        }
        editor.apply();
    }

    private ArrayList<Notes> loadArray(Context context)
    {
        ArrayList<Notes>answer=new ArrayList<>();
        SharedPreferences sharedPreferences=getSharedPreferences("Mypref",MODE_PRIVATE);
        int size=sharedPreferences.getInt("SIZE",0);
        for(int i=0;i<size;i++)
        {
            String note=sharedPreferences.getString("NOTES",null);
            String time=sharedPreferences.getString("TIME",null);
            answer.add(new Notes(note,time));
        }
        return answer;
    }
}
