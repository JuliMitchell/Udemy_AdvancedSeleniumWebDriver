package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage  extends BasePage{

    private By seleccionarArchivoButtonLinkLocator = By.id("file-upload");
    private By uploadButtonLocator = By.id("file-submit");

    public FileUploaderPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void selectFile(String fileName){
        log.info("Selecting '" + fileName + "' file.");
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
        type(seleccionarArchivoButtonLinkLocator, filePath);
        log.info("File selected.");
    }

    public FileUploadedPage clickUploadButton(){
        log.info("Clicking Upload button");
        click(uploadButtonLocator);
        return new FileUploadedPage(driver, log);
    }



}
