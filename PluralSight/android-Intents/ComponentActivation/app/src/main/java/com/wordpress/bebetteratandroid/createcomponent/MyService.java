package com.wordpress.bebetteratandroid.createcomponent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {

    private int _callCount;

    //TODO : What is the difference and need of constructor in service?
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _callCount = 0;
        Log.i("MyService","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        _callCount++;
        Log.i("MyService","onStartCommand - call #" + _callCount);
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
