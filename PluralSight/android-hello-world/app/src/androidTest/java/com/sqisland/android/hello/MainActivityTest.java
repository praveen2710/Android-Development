package com.sqisland.android.hello;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * This class will run tests on the main activity of the application
 * Created by pb033954 on 3/3/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule=
            new ActivityTestRule<MainActivity>(MainActivity.class);

    /**
     * This will open app select menu option say bye and compare results before
     * and after
     */
    @Test
    public void bye(){
        onView(withId(R.id.greeting)).check(matches(withText(R.string.hello_world)));

        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText(R.string.say_bye)).perform(click());

        onView(withId(R.id.greeting)).check(matches(withText(R.string.bye)));
    }
}