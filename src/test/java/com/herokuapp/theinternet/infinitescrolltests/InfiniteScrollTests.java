package com.herokuapp.theinternet.infinitescrolltests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.InfiniteScrollPage;
import com.herokuapp.theinternet.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfiniteScrollTests extends TestUtilities {
    @Test
    public void scrollToSeeFiveParagraphs() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, log);
        mainPage.openPage();

        InfiniteScrollPage infiniteScrollPage = mainPage.clickInfiniteScrollLink();

        infiniteScrollPage.scrollToTheBottom(4);

        Assert.assertEquals(infiniteScrollPage.getParagraphQuantity(), 5, "The paragraphs quantity isn't correct");
    }
}
