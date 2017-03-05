package com.wordpress.bebetteratandroid.createcomponent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Creating Custom menu option
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater() ;
        inflater.inflate(R.menu.main_menu, menu) ;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuCallExlpicitActivity:
                showExplicitActivity();
                break;
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

    /**
     * This function intially made call implicity and now should make call explicitly to service
     */
    private void runService() {
        Log.i("runService","Intialize the service");
        Intent startServiceIntent = new Intent(this,MyService.class);
        //TODO Using implicit intent causes app crashes?
//        Intent startServiceIntent = new Intent("com.wordpress.bebetteratandroid.createcomponent.LOG_TIME");
        startService(startServiceIntent);
    }

    /**
     * This function will create an intent with specific acitibity name
     * and then start that activity.
     */
    private void showExplicitActivity() {
        Log.i("showExplicitActivity","Intialize the explicit activity");
        Intent showExplicitIntent = new Intent(this,ExplicitActivity.class);
        //TODO figure out how to avoid multiple instance of activity from being created?
        showExplicitIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(showExplicitIntent);
    }
}
