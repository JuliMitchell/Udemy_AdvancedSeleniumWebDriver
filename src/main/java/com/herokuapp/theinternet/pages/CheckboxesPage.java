package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePage {

    private By checkboxLocator = By.xpath("//input[@type='checkbox']");

    public CheckboxesPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void selectAllCheckboxes(){
        log.info("Checking all unchecked checkboxes");
        List<WebElement> checkboxes = findAll(checkboxLocator);
        checkboxes.stream().forEach(checkbox -> {
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        });
    }

    public boolean areAllCheckboxesSelected(){
        log.info("Verifying that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkboxLocator);
        for(WebElement checkbox : checkboxes){
            if(!checkbox.isSelected()){
                return false;
            }
        }
        return true;
    }
}
