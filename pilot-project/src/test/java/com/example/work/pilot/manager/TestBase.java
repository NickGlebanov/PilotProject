package com.example.work.pilot.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {
        app.start();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
