package com.codingblocks.batterysaverapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ChargingActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charging);
        TextView textView=findViewById(R.id.tvlevel1);
        textView.setText(getLevel()+" PERCENT");
    }
    public float getLevel()
    {
        Intent intent=registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        int scale=intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
        if(level==-1||scale==-1)
        {
            return (float) 50.0;
        }
        return ((float)level/(float)scale)*100;
    }
}
