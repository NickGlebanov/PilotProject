package com.example.work.pilot.manager;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        app.start();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}
