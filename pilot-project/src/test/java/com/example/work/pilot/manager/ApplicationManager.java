package com.example.work.pilot.manager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    private SpecificationHelper specificationHelper;
    private SearchHelper searchHelper;

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        searchHelper = new SearchHelper(driver);
        specificationHelper = new SpecificationHelper(driver);
    }

    public void enterWebsite() {
      driver.get("https://market.yandex.ru/");
    }

    public void stop() {
        driver.quit();
    }

    public SearchHelper getSearchHelper() {
        return searchHelper;
    }

    public SpecificationHelper getSpecificationHelper() {
        return specificationHelper;
    }
}
