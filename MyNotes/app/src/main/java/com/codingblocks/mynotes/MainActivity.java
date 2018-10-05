package com.codingblocks.mynotes;

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
    String input;
    String time;
    ArrayList<Notes>arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.etNote);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        Map<String,?>allEntries=sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.e("map values", entry.getKey() + ": " + entry.getValue().toString());
            if(entry.getKey()=="NOTES")
            {
                TextView textView=findViewById(R.id.tvnote);
                textView.setText((CharSequence) entry.getValue());
            }
            else if(entry.getKey()=="TIME")
            {
                TextView textView=findViewById(R.id.tvtime);
                textView.setText((CharSequence) entry.getValue());
            }
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        final NotesAdapter notesAdapter=new NotesAdapter(arrayList);
        recyclerView.setAdapter(notesAdapter);
        Button btnadd=findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=et.getText().toString();
                time = String.valueOf(System.currentTimeMillis());
                arrayList.add(new Notes(input,time));
                notesAdapter.notifyDataSetChanged();
                et.setText("");
            }
        });
    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("NOTES", et.getText().toString());
        editor.putString("TIME",time);
        editor.apply();
        super.onStop();
    }
}
