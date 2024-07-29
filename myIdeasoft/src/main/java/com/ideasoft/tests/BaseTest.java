package com.ideasoft.tests;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    protected static String driverName = "webdriver.chrome.driver";
    protected static String driverPath = "src/main/resources/driver/chromedriver.exe";
    protected static String url = "https://testcase.myideasoft.com/";

    public static WebDriver getDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); //tarayıcı boyutu
        options.addArguments("disble-popup-blocking"); //popup kapat
        options.addArguments("disable-notifications"); //bildirimleri kapat
        options.addArguments("test-type"); //Test tipinde aç
        System.setProperty(driverName,driverPath);
        driver=new ChromeDriver(options); //ön ayarlarla driver ayağa kalkar
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    @Before
    public void setup(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        getDriver();
        waitForDocumentLoad(driver);
        waitForAjaxLoad(driver);
        waitForDocumentLoad(driver);
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    private static void waitForDocumentLoad(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return  document.readyState").equals("complete");}});
    }

    private static void waitForAjaxLoad(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElements(By.cssSelector(".waiting, .tb-loading")).size() == 0;}});
    }

    public void tearDownScenario(Scenario scenario) {
        if (scenario.isFailed()) {// capturing the screenshot when a scenario fails and attaching it to the report
            final byte[] failedScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario" + scenario.getName() + "");
            driver.quit();
        }
    }
}
