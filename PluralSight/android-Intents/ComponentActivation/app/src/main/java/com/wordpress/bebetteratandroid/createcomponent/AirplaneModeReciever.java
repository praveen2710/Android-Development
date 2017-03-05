package com.wordpress.bebetteratandroid.createcomponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AirplaneModeReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        Log.i("AirplaneModeReciever","came in here");
        boolean modeIsOn = intent.getBooleanExtra("state",false);
        Log.i("AirplaneModeReciever","Mode is "+(modeIsOn? "on":"off"));
    }
}
