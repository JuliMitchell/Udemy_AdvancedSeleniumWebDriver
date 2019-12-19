package com.herokuapp.theinternet.jserrortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSOnloadEventErrorPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSOnloadEventErrorTests extends TestUtilities {

    @Test
    public void jsErrorTest(){
        log.info("Starting jsErrorTest");

        SoftAssert softAssert = new SoftAssert();

        MainPage mainPage = new MainPage(driver, log);

        mainPage.openPage();

        JSOnloadEventErrorPage jsOnloadEventErrorPage = mainPage.clickJSOnloadEventErrorLink();

        softAssert.assertTrue(!jsOnloadEventErrorPage.checkSeveralErrorExist(getBrowserLogs()));

        softAssert.assertAll();
    }
}
