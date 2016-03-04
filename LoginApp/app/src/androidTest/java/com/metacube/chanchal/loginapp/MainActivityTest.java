package com.metacube.chanchal.loginapp;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
/**
 * Created by Chanchal on 01-03-2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void usernameTextValidator() throws InterruptedException {
        onView(withId(R.id.uname)).perform(typeText("chanchal"));
        Thread.sleep(3000);
        pressBack();
        onView(withId(R.id.uname)).check(matches(withText("chanchal")));
        Thread.sleep(3000);

        onView(withId(R.id.pass)).perform(typeText("dabriya"));
        closeSoftKeyboard();
        Thread.sleep(3000);
        onView(withId(R.id.pass)).check(matches(withText("dabriya")));
        Thread.sleep(3000);

        onView(withId(R.id.button)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.gridView)).check(matches(isDisplayed()));
        Thread.sleep(3000);
    }

}
