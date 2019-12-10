package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePage {

    private By clickHereLinkLocator = By.xpath("//a[text()='Click Here']");

    public WindowsPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void openNewWindow(){
        log.info("Clicking 'Click Here' link");
        click(clickHereLinkLocator);
    }

    public NewWindowPage switchToNewWindowsPage(){
        String newPageTitle = "New Window";
        switchToOtherPage(newPageTitle);
        log.info("Switching to " + newPageTitle + " page");
        return new NewWindowPage(driver, log);
    }

}
