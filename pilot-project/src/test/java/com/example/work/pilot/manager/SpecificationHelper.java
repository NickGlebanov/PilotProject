package com.example.work.pilot.manager;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SpecificationHelper {
    public WebDriver driver;

    public SpecificationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String getColor(By locator, String text) {
      return driver.findElement(locator).getAttribute(text);
    }

    public void getWindow(int i) {
      ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles()); // список всех вкладок
      driver.switchTo().window(newTab.get(i)); // берем вторую вкладку
    }

    @NotNull
    public List<WebElement> getWebElements() {
        List<WebElement> list = new ArrayList();
        List<WebElement> listElements = driver.findElements(By.tagName("dd"));
        for (WebElement e : listElements) {
            list.add(e);   // Достуг того, что выгружены все характеристики, теперь надо добавить в модульный объект нужные
        }
        return list;
    }
}
