package com.example.work.pilot.manager;

import com.example.work.pilot.classes.NintendoSpecification;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpecificationHelper extends HelperBase{

    ApplicationManager ap;

    public SpecificationHelper(WebDriver driver, ApplicationManager ap) {
        super(driver);
        this.ap = ap;
    }

    public String getColor() {
      return getAttribute(By.xpath("//div[@class='_2PZFauqN3Y']"), "title");
    }

    public void getWindow(int i) {
      ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles()); // список всех вкладок
      driver.switchTo().window(newTab.get(i)); // берем вторую вкладку
    }

    @NotNull
    public List<WebElement> getListPoints() {
        List<WebElement> list = new ArrayList();
        List<WebElement> listElements = driver.findElements(By.tagName("dd"));
        for (WebElement e : listElements) {
            list.add(e);   // Выгружены все характеристики, теперь надо добавить в модульный объект нужные
        }
        return list;
    }

    public List<WebElement> getListColor() {
        List<WebElement> list = new ArrayList<>();
        List<WebElement> listElements = driver.findElements(By.xpath("//div[@class='_2PZFauqN3Y']"));
        for (WebElement e : listElements) {
            list.add(e);   // коллекция всех цветов
        }
        return list;
    }

    public NintendoSpecification getNintendo(String type, String screen, String controller, String accessories, String color, String memory, String weight) {
        NintendoSpecification nt1 = new NintendoSpecification().withType(type).withScreen(screen).
                withController(controller).withAccessories(accessories).
                withColor(color).withMemory(memory).withWeight(weight);
    return nt1;
    }

}
