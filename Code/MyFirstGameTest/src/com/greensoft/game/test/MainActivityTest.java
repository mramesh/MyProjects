
package com.greensoft.game.test;

import android.test.ActivityInstrumentationTestCase2;

import com.greensoft.game.SampleGame;

public class MainActivityTest extends ActivityInstrumentationTestCase2<SampleGame> {

    public MainActivityTest() {
        super(SampleGame.class);
    }

    public void testViewNotNull() throws Exception {
        System.out.println(" Test Sucess 111");
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
