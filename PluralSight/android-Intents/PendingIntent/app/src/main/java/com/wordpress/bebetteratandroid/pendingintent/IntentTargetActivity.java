package com.wordpress.bebetteratandroid.pendingintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Set;

public class IntentTargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_target);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        TextView textViewIntentInfo = (TextView) findViewById(R.id.textViewIntentInfo);

        showIntentInfo(intent, textViewIntentInfo);
    }

    /**
     * This will show the action and extra's associated to intent that called this activity
     * @param intent
     * @param textView
     */
    private void showIntentInfo(Intent intent, TextView textView){
        StringBuilder infoBuilder = new StringBuilder();
        String action = intent.getAction();
        infoBuilder.append("Action=");
        infoBuilder.append(action != null ? action : "** NO Action **");
        infoBuilder.append("\n");

        Bundle extras = intent.getExtras();
        if(extras == null){
            infoBuilder.append("** NO Extras **");
        }   else {
            infoBuilder.append("** Extras **\n");
            Set<String> keySet = extras.keySet();
            for(String key : keySet) {
                String value = extras.get(key).toString();
                infoBuilder.append(key);
                infoBuilder.append("=");
                infoBuilder.append(value);
                infoBuilder.append("\n");
            }
        }
        textView.setText(infoBuilder.toString());
    }

}
