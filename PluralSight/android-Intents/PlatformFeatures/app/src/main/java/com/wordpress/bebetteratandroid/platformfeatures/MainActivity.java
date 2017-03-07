package com.wordpress.bebetteratandroid.platformfeatures;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuOptionCheckBatteryStatus:
                checkBatteryStatus();
                break;
            case R.id.menuQuit:
                finish();
                break;
            case R.id.menuShowActivity:
                scheduleActivity();
                break;
            case R.id.menuViewLinkedIn:
                viewMyProfile();
                break;
            case R.id.menuCallMe:
                contactMe();
                break;
            default:
                super.onOptionsItemSelected(item);
                break;
        }
        return true;
    }

    private void contactMe() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:2022976795"));
        startActivity(intent);
    }

    /**
     * Calling inbuild service to view a web page
     */
    private void viewMyProfile() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/praveenbanthia"));
        startActivity(intent);
    }

    /**
     * This method is to show how we can start an activity with 5 sec delay using system service
     */
    private void scheduleActivity() {
        Intent intent = new Intent("com.wordpress.bebetteratandroid.platformfeatures.DELAYED_TIMER");
        intent.putExtra("Name", "Praveen");
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        long alarmTime = SystemClock.elapsedRealtime() + 5000;
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, alarmTime, pi);
    }

    /**
     * This method is to register actions that cannot be registered at compile time
     */
    private void checkBatteryStatus() {
        BatteryStatusReceiver b1 = new BatteryStatusReceiver();
        this.registerReceiver(b1,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
