package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {

    public static WebDriver driver;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {

        BrowserDriverFactory factory = new BrowserDriverFactory("chrome");
        driver = factory.createDriver();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Close driver");
        // Close browser
        driver.quit();
    }
}
