package com.wordpress.bebetteratandroid.createcomponent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        SimpleDateFormat dateFormat= null;
        String action = intent.getAction();
        if(action != null) {
            if (action.equals("com.wordpress.bebetteratandroid.createcomponent.LOG_TIME")) {
                dateFormat = new SimpleDateFormat("HH:mm:ss");
            } else if (action.equals("com.wordpress.bebetteratandroid.createcomponent.LOG_DATE")) {
                dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            } else {
                Log.i("MyService", "unrecongnized action");
            }

            if(dateFormat != null){
                Long now = (new Date()).getTime();
                Log.i("MyService",dateFormat.format(now));
            }
        }

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
