package com.ideasoft.util;

import com.ideasoft.tests.BaseTest;
import io.cucumber.java.After;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public abstract class BasePageUtil {

    public static WebDriver driver = BaseTest.getDriver();

    @After

    public WebElement find(By element){
        //elementi 15 sn ara bulamazsan patlat
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean isElementDisplayed(By element) {
        return find(element).isDisplayed();
    }

    public boolean isEnabled(By element) {
        return  find(element).isEnabled();
    }

    public void sendKeys(By element, String text) {
        find(element).sendKeys(text);
    }

    public void clickElement(By element) {
        find(element).click();
    }

    public String getAttribute(By element,String text)  {
        return find(element).getAttribute(text);
    }

    public String getText(By element ) {
        return find(element).getText();
    }

    public void swipeToElement(By by, int index) {

        List<WebElement> element = driver.findElements(by);
        /*
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return element;*/

        Actions act = new Actions(driver);
        //act.moveToElement(element).click().build().perform();
        act.moveToElement(element.get(index)).perform();
    }

   public void clickElementOnList (By element, int index){
        //WebDriverWait wait=new WebDriverWait(driver,5);
        driver.findElements(element).get(index).click();
   }

   public void keyENTER(By by){
        driver.findElement(by).sendKeys(Keys.ENTER);
   }

    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void PageScrolldown() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("window.scrollBy(0,500)", "");
    }

    public void PageScrollup() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("window.scrollBy(0,-300)", "");

    }
    public void scrollToElement(By element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}


