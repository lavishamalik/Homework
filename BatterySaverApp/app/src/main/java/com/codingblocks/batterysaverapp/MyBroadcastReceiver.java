package com.codingblocks.batterysaverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction())
        {
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context,"POWER CONNECTED",Toast.LENGTH_LONG).show();
                Intent i=new Intent(context,ChargingActivity.class);
                context.startActivity(i);
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context,"POWER DISCONNECTED",Toast.LENGTH_LONG).show();
                Intent i2=new Intent(context,DischargingActivity.class);
                context.startActivity(i2);
                break;
            case Intent.ACTION_BATTERY_LOW:
                Intent intent1=new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
                context.startActivity(intent1);
                break;
        }
    }
}
