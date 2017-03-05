package com.wordpress.bebetteratandroid.implicitservicecall;

import android.util.Log;

/**
 * Created by pb033954 on 3/4/2017.
 */

public class LogHelper {
    public static void ProcessAndThreadId(String label){
        String logMessage  = String.format("%s, Process Id:%d, Thread Id:%d",label,android.os.Process.myPid(), android.os.Process.myTid());
        Log.i("LogHelper",logMessage);;
    }
}
