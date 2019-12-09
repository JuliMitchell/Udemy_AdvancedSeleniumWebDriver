package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{

    private By dropdownLocator = By.id("dropdown");

    public DropdownPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void selectOption(int identificator){
        log.info("Selecting 'Option " + identificator + "' from dropdown.");
        WebElement dropdownElement = find(dropdownLocator);
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByIndex(identificator);
        //dropdown.selectByValue("" + identificator);
        //dropdown.selectByVisibleText("Option " + identificator);
    }

    public String getSelectedOption(){
        WebElement dropdownElement = find(dropdownLocator);
        Select dropdown = new Select(dropdownElement);
        return dropdown.getFirstSelectedOption().getText();
    }
}
