package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected Logger log;

    public BasePage(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }

    protected void openUrl(String url){
        driver.get(url);
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void click(By locator){
        waitForVisibilityOf(locator, 5);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text){
        waitForVisibilityOf(locator, 5);
        driver.findElement(locator).sendKeys(text);
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutSEC){
        timeOutSEC = timeOutSEC != null ? timeOutSEC : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutSEC);
        wait.until(condition);
    }

    private void waitForVisibilityOf(By locator, Integer... timeOutSEC){
        int attempts = 0;
        while(attempts < 2){
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutSEC.length > 0 ? timeOutSEC[0] : null));
                break;
            } catch (StaleElementReferenceException e){
                e.printStackTrace();
            }
            attempts++;
        }
    }
}
