package com.herokuapp.theinternet.dropdownTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Test
    public void selectOptionOne(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        DropdownPage dropdownPage = mainPage.clickDropdownLink();

        dropdownPage.selectOption(1);

        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption, "Option 1", "Option 1 isn't selected. Instead selected: " + selectedOption );

    }

    @Test
    public void selectOptionTwo(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        DropdownPage dropdownPage = mainPage.clickDropdownLink();

        dropdownPage.selectOption(2);

        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption, "Option 2", "Option 2 isn't selected. Instead selected: " + selectedOption );

    }

}
