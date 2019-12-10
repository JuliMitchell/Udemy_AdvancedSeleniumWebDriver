package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator){
        waitForVisibilityOf(locator, 5);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text){
        waitForVisibilityOf(locator, 5);
        driver.findElement(locator).sendKeys(text);
    }

    protected Alert switchToAlert(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutSEC){
        timeOutSEC = timeOutSEC != null ? timeOutSEC : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutSEC);
        wait.until(condition);
    }

    public void waitForVisibilityOf(By locator, Integer... timeOutSEC){
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

    protected void switchToOtherPage(String pageTitle){
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while(windowsIterator.hasNext()){
            String windowHandle = windowsIterator.next().toString();
            if(!windowHandle.equals(firstWindow)){
                driver.switchTo().window(windowHandle);
                if(getCurrentWindowTitle().equals(pageTitle)){
                    break;
                }
            }
        }

    }

    public String getCurrentWindowTitle(){ return driver.getTitle(); }

    public String getBrowserUrl(){
        return driver.getCurrentUrl();
    }

    public String getCurrentPageSource() { return driver.getPageSource(); }

    protected void switchToFrame(By locator){
        driver.switchTo().frame(find(locator));
    }

    protected void pressKey(By locator, Keys key){
        find(locator).sendKeys(key);
    }

    public void pressKeyWithActions(Keys key){
        Actions actions = new Actions(driver);
        actions.sendKeys(key).build().perform();
    }

}
