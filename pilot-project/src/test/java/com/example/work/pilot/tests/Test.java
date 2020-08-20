package com.example.work.pilot.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.work.pilot.classes.NintendoSpecification;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    enterWebsite();
    driver.findElement(By.id("header-search")).sendKeys("nintendo switch");
    driver.findElement(By.xpath("//button[@class='_1XiEJDPVpk']")).click();
    String oneTab = driver.getWindowHandle(); // сохраняем первую вкладку
    type(By.linkText("Игровая приставка Nintendo Switch"));
    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles()); // список всех вкладок
    driver.switchTo().window(newTab.get(1)); // берем вторую вкладку
    //new Select(driver.findElement(By.id("dropdown-control-1597759688456"))).selectByVisibleText("нет");
    type(By.linkText("Характеристики"));
    String colorSwitch = driver.findElement(By.xpath("//div[@class='_2PZFauqN3Y']")).getAttribute("title");


    List<WebElement> list = new ArrayList();
    List<WebElement> listElements = driver.findElements(By.tagName("dd"));
    for(WebElement e : listElements) {
      list.add(e);   // Достуг того, что выгружены все характеристики, теперь надо добавить в модульный объект нужные
    }
    NintendoSpecification nt = new NintendoSpecification().withType(list.get(1).getText()).withScreen(list.get(3).getText()).
            withController(list.get(16).getText()).withAccessories(list.get(17).getText()).
            withColor(colorSwitch).withMemory(list.get(8).getText()).withWeight(list.get(15).getText());


    search();
    ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(newTab1.get(2));
    type(By.linkText("Характеристики"));
    String colorLite = driver.findElement(By.xpath("//div[@class='_2PZFauqN3Y']")).getAttribute("title"); // сделать потом Коллекцию цветов и выбирать один из них

    List<WebElement> list1 = new ArrayList();
    List<WebElement> listElements1 = driver.findElements(By.tagName("dd"));
    for(WebElement e : listElements1) {
      list1.add(e);   // Достуг того, что выгружены все характеристики, теперь надо добавить в модульный объект нужные
    }

    NintendoSpecification nt1 = new NintendoSpecification().withType(list1.get(1).getText()).withScreen(list1.get(2).getText()).
            withController(null).withAccessories(null).
            withColor(colorLite).withMemory(list1.get(12).getText()).withWeight(list1.get(19).getText());

    Assert.assertEquals(nt.getType(), nt1.getType());
    Assert.assertEquals(nt.getColor(), nt1.getColor());
    Assert.assertEquals(nt.getMemory(), nt1.getMemory());
    Assert.assertEquals(nt.getScreen(), nt1.getScreen());
  }

  public void type(By locator) {
    driver.findElement(locator).click();
  }

  public void search() {
    driver.findElement(By.id("header-search")).sendKeys("nintendo switch");
    driver.findElement(By.xpath("//button[@class='_1XiEJDPVpk']")).click();
    type(By.linkText("Игровая приставка Nintendo Switch Lite"));
  }

  public void enterWebsite() {
    driver.get("https://market.yandex.ru/");
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
