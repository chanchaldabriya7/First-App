package com.metacube.chanchal.loginapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void loginCheckTest() {
        MainActivity obj = new MainActivity();
        assertTrue( "Login is successful",obj.loginCheck("chanchal","dabriya") );
    }
    @Test
    public void loginCheckTestTwo() {
        MainActivity obj = new MainActivity();
        assertEquals( "Login is successful",obj.loginCheck("chanchal","dabriya"),true);
    }
}