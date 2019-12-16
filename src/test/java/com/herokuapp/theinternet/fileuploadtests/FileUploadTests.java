package com.herokuapp.theinternet.fileuploadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploadedPage;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void uploadWithFile(int testNumber, String fileName){
        log.info("Starting test #" + testNumber + " with file '" + fileName + "'");

        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        FileUploaderPage fileUploaderPage = mainPage.clickFileUploadLink();

        fileUploaderPage.selectFile(fileName);

        FileUploadedPage fileUploadedPage = fileUploaderPage.clickUploadButton();

        String fileUploadedName = fileUploadedPage.getFileUploadedName();
        Assert.assertTrue(fileUploadedName.equals(fileName), "File name isn't correct");

    }

    @Test
    public void uploadWithoutFile(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        FileUploaderPage fileUploaderPage = mainPage.clickFileUploadLink();

        FileUploadedPage fileUploadedPage = fileUploaderPage.clickUploadButton();

        String errorMessage = fileUploadedPage.getErrorMessageText();

        Assert.assertTrue(errorMessage.equals("Internal Server Error"), "Error message text isn't correct");

    }
}
