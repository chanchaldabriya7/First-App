package com.metacube.chanchal.loginapp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import org.junit.Test;
/**
 * Created by Chanchal on 01-03-2016.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
        MainActivity activity;
        MainActivityTest() {
            super(MainActivity.class);
            activity = getActivity();
        }
        @Test
        public void usernameTextValidator() {
            TextView username= (TextView) activity.findViewById(R.id.uname);
            assertNotNull("Field cannot be null", username);
        }
}
