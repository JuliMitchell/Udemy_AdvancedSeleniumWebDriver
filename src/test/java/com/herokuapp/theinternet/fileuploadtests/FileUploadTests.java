package com.herokuapp.theinternet.fileuploadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploadedPage;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends TestUtilities {

    @Test
    public void uploadWithFile(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        FileUploaderPage fileUploaderPage = mainPage.clickFileUploadLink();

        String fileName = "data.png";
        fileUploaderPage.selectFile(fileName);

        FileUploadedPage fileUploadedPage = fileUploaderPage.clickUploadButton();

        String fileUploadedName = fileUploadedPage.getFileUploadedName();
        Assert.assertTrue(fileUploadedName.equals(fileName), "File name isn't correct");

    }
}
