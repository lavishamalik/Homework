package com.codingblocks.counterapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int count=0;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btninc=findViewById(R.id.btninc);
        Button btndec=findViewById(R.id.btndec);
        SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        textView = findViewById(R.id.tvans);
        count=sharedPreferences.getInt("COUNT",0);
        textView.setText(String.valueOf(count));
        btninc.setOnClickListener(this);
        btndec.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btninc:
                    count++;
                    break;
                case R.id.btndec:
                    count--;
                    break;
            }
            textView.setText(String.valueOf(count));
    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("COUNT",count);
        editor.apply();
        super.onStop();
    }
}
