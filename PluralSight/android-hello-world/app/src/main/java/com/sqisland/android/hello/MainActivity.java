package com.sqisland.android.hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

  private TextView greetingView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    greetingView = (TextView) findViewById(R.id.greeting);
  }

  /**
   * This is overriding default menu option with custom menu.
   * Menu inflater takes 2 inputs one the xml containing menu details
   * and menu object passed in
   * @param menu: Menu object
   * @return true
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
  }

  /**
   * Here we assign action to menu items that we are showing in
   * {@code onCreateOptionsMenu}
   * @param item : Respective Menu Item
   * @return true if  menu item with action selected else default
   *
   */
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if(item.getItemId() == R.id.action_bye){
      greetingView.setText(R.string.bye);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }


}