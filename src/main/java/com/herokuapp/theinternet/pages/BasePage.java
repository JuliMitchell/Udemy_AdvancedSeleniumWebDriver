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

    public void scrollToBottom(){
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void dragAndDrop(WebElement from, WebElement to){
        //Actions actions = new Actions(driver);
        //actions.dragAndDrop(from, to);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", from, to);
    }
}
