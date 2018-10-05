package com.codingblocks.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Add(View view) {
        EditText t1=findViewById(R.id.t1);
        EditText t2=findViewById(R.id.t2);
        String t1s=t1.getText().toString();
        String t2s=t2.getText().toString();
        int ans=Integer.parseInt(t1s)+Integer.parseInt(t2s);
        TextView answer=findViewById(R.id.res);
        answer.setText(""+ans);
    }

    public void Sub(View view) {
        EditText t1=findViewById(R.id.t1);
        EditText t2=findViewById(R.id.t2);
        String t1s=t1.getText().toString();
        String t2s=t2.getText().toString();
        int ans=Integer.parseInt(t1s)-Integer.parseInt(t2s);
        TextView answer=findViewById(R.id.res);
        answer.setText(""+ans);
    }

    public void Mult(View view) {
        EditText t1=findViewById(R.id.t1);
        EditText t2=findViewById(R.id.t2);
        String t1s=t1.getText().toString();
        String t2s=t2.getText().toString();
        int ans=Integer.parseInt(t1s)*Integer.parseInt(t2s);
        TextView answer=findViewById(R.id.res);
        answer.setText(""+ans);
    }

    public void Div(View view) {
        EditText t1=findViewById(R.id.t1);
        EditText t2=findViewById(R.id.t2);
        String t1s=t1.getText().toString();
        String t2s=t2.getText().toString();
        int ans=Integer.parseInt(t1s)/Integer.parseInt(t2s);
        TextView answer=findViewById(R.id.res);
        answer.setText(""+ans);
    }

    public void clear(View view) {
        EditText t1=findViewById(R.id.t1);
        EditText t2=findViewById(R.id.t2);
        TextView answer=findViewById(R.id.res);
        answer.setText("");
        t1.setText("");
        t2.setText("");
    }
}
