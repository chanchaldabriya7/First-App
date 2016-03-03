package com.metacube.chanchal.loginapp;

import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.intent.Intents.*;
import static android.support.test.espresso.intent.matcher.IntentMatchers.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
/**
 * Created by Chanchal on 01-03-2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> mIntentRule = new IntentsTestRule<MainActivity>(MainActivity.class);


    @Test
    public void usernameTextValidator() {
        onView(withId(R.id.uname)).perform(typeText("chanchal"));
        onView(withId(R.id.uname)).check(matches(withText("chanchal")));

        onView(withId(R.id.pass)).perform(typeText("dabriya"));
        onView(withId(R.id.pass)).check(matches(withText("dabriya")));

        onView(withId(R.id.button)).perform(click());
        //intended(toPackage("com.metacube.chanchal.loginapp"));
        onView(withId(R.id.gridView)).check(matches(isDisplayed()));
    }

}
