package com.wordpress.bebetteratandroid.implicitservicecall;

import android.content.Intent;
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuRunService:
                runService();
                break;
            case R.id.menuQuit:
                finish();
                break;
            default:
                super.onOptionsItemSelected(item);
                break;
        }
        return true;
    }

    private void runService() {
        LogHelper.ProcessAndThreadId("Calling app");
        //TODO : figure out why the impicit call is crahsing?
//        Intent runServiceIntent = new Intent("com.wordpress.bebetteratandroid.createcomponent.LOG_TIME");
//        startService(runServiceIntent);
    }
}
