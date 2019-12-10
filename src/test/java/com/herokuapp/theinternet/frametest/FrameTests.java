package com.herokuapp.theinternet.frametest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.IFramePage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends TestUtilities {
    @Test
    public void getFrameEditorText(){
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        IFramePage iFramePage = mainPage.clickWYSIWYGEditorLink();

        iFramePage.switchToFrameEditor();

        String text = iFramePage.getTextEditor();
        Assert.assertTrue(text.equals("Your content goes here."), "Text Editor isn't correct");
    }
}
