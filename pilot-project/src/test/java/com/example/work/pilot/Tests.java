package com.example.work.pilot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class Tests {
  private WebDriver driver;

  @BeforeTest(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testS() throws Exception {
    driver.get("https://market.yandex.ru/");
    driver.findElement(By.id("header-search")).sendKeys("nintendo switch");
    driver.findElement(By.xpath("//button[@class='_1XiEJDPVpk']")).click();
    driver.findElement(By.xpath("//h3[./a[@title='Игровая приставка Nintendo Switch']]")).click();
    driver.findElement(By.xpath("//a[@data-tid='b5c75e4a']")).click();
    driver.findElement(By.linkText("Игровая приставка Nintendo Switch серый обновленная версия")).click();
    //driver.get("https://market.yandex.ru/search?text=nintendo%20switch&cvredirect=2&suggest_history=1&local-offers-first=0");
    //driver.findElement(By.xpath("//h3[./a[@title='Игровая приставка Nintendo Switch']]")).click();
    //driver.findElement(By.xpath("//div[./a[@data-tid='b5c75e4a']]")).click();




    //driver.get("https://yandex.ru/");
    //driver.findElement(By.xpath("//input[@id='text']")).sendKeys("яндекс маркет");
    //driver.findElement(By.xpath("//div[./button[@type='submit']]")).click();
    //driver.findElement(By.xpath("//div[./b[@class='needsclick']]")).click();
    //driver.findElement(By.id("header-search")).sendKeys("nintendo switch");



  }

  @AfterTest(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
