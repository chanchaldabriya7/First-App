package com.metacube.chanchal.loginapp;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;
import android.test.AndroidTestRunner;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

/**
 * Created by Chanchal on 01-03-2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{

    MainActivity activity;
    public MainActivityTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Before
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();
    }

    @Test
    public void usernameTextValidator() throws Exception {
        System.out.println("1st statement");
        TextView username= (TextView) activity.findViewById(R.id.uname);
        System.out.println("2nd statement");
        assertNotNull("Field cannot be null", username);
        System.out.println("3rd statement");
    }

    @After
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
