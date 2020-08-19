package com.example.work.pilot.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.work.pilot.classes.NintendoSpecification;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class Test {
  private WebDriver driver;

  @BeforeTest(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @org.testng.annotations.Test
  public void testS() throws Exception {
    driver.get("https://market.yandex.ru/");
    driver.findElement(By.id("header-search")).sendKeys("nintendo switch");
    driver.findElement(By.xpath("//button[@class='_1XiEJDPVpk']")).click();
    String oldTab = driver.getWindowHandle(); // сохраняем первую вкладку
    driver.findElement(By.xpath("//h3[./a[@title='Игровая приставка Nintendo Switch']]")).click();
    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles()); // список всех вкладок
    driver.switchTo().window(newTab.get(1)); // берем вторую вкладку
    //new Select(driver.findElement(By.id("dropdown-control-1597759688456"))).selectByVisibleText("нет");
    driver.findElement(By.linkText("Характеристики")).click();
    Thread.sleep(2000);
    String color = driver.findElement(By.xpath("//div[@class='_2PZFauqN3Y']")).getAttribute("title");

   // List list = new ArrayList();
    //List<WebElement> listElements = driver.findElements(By.xpath("//div[@class='la3zd2uWXG']"));
    //for(WebElement e : listElements) {
    //  List<WebElement> cells = e.findElements(By.tagName("dd"));
    //  String type = cells.get(0).getText();
    //  String screen = cells.get(1).getText();
    //  NintendoSpecification nt = new NintendoSpecification().withType(type).withScreen(screen);
    //  list.add(nt);
   // }

    List list = new ArrayList();
    List<WebElement> listElements = driver.findElements(By.tagName("dd"));
    for(WebElement e : listElements) {
      System.out.println(e.getText());
    }

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
