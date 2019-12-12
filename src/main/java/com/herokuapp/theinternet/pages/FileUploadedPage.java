package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadedPage extends BasePage {

    private By fileUploadedName = By.id("uploaded-files");

    public FileUploadedPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getFileUploadedName(){
        return find(fileUploadedName).getText();
    }
}
