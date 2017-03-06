package com.wordpress.bebetteratandroid.pendingintent;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    final int _notificationId1 = 1;
    final int _notificationId2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater() ;
        inflater.inflate(R.menu.main_menu, menu) ;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuCreatePendingIntent:
                createPendingIntents();
                break;
            default:
                super.onOptionsItemSelected(item);
                break;
        }

        return true;
    }

    private void createPendingIntents() {
        int flagValue = 3;
        PendingIntent pi1 = createPI1();
        createAndAddNotification(pi1,"Pending Intent 1",R.drawable.ic_stat_name,_notificationId1);
        PendingIntent pi2 = createPI2(flagValue);
        createAndAddNotification(pi2,"Pending Intent 2",R.drawable.ic_stat_name,_notificationId2);


        boolean isEqual = pi1.equals(pi2);
        Log.i("createPendingIntents","Pending intents are equal:"+ (isEqual?"YES": "NO"));
    }



    private PendingIntent createPI1() {
        Intent intent = new Intent("com.wordpress.bebetteratandroid.pendingintent.SHOW_TEST_ACTIVITY");
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);

        return pi;
    }

    /**
     * This will take a int value which will flex the flag for pending intent to show different behavior
     * @param flagValue : 1 will update the extra's in underlying intent to latest intent data
     *                  : 2 the second pending intent will only be created once
     *                  : 3 once second intent is created first one will be become invalid
     * @return
     */
    private PendingIntent createPI2(int flagValue) {
        Intent intent = new Intent("com.wordpress.bebetteratandroid.pendingintent.SHOW_TEST_ACTIVITY");
        intent.putExtra("Name ", "Praveen Banthia");
        intent.putExtra("Passion ","Development");
        PendingIntent pi = null;
        switch (flagValue){
            case 1: pi = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                break;
            case 2: pi = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
                break;
            case 3: pi = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                break;
            default:
                pi = PendingIntent.getActivity(this,0,intent,0);
        }

        return pi;
    }

    private void createAndAddNotification(PendingIntent pi, String notificationText, int notificationIcon, int notificationId){
        long notificationTimeStamp = System.currentTimeMillis();
        Notification notification  = new Notification.Builder(this)
                                    .setContentText(notificationText)
                                    .setContentIntent(pi)
                                    .setSmallIcon(notificationIcon)
                                    .setWhen(notificationTimeStamp)
                                    .build();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId,notification);
    }
}
