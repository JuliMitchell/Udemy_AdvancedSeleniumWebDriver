package com.herokuapp.theinternet.checkboxestests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {
    @Test
    public void selectingTwoCheckboxesTests() throws InterruptedException {
        log.info("Starting selectingTwoCheckboxesTests");

        MainPage mainPage = new MainPage(driver, log);

        mainPage.openPage();

        CheckboxesPage checkboxesPage = mainPage.clickCheckboxesLink();

        checkboxesPage.selectAllCheckboxes();

        Assert.assertTrue(checkboxesPage.areAllCheckboxesSelected(), "Not all checkboxes are checked");
    }
}
