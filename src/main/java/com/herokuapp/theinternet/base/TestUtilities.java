package com.herokuapp.theinternet.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtilities extends BaseTest{

    protected void sleep(long time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @DataProvider(name="files")
    protected static Object[][] files(){
        return new Object[][]{
                {1, "index.html"},
                {2, "logo.png"},
                {3, "text.txt"}
        };
    }

    private static String getTodaysDate(){
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    public String getSystemTime(){
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }

    protected void takeScreenshot(String fileName){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + getTodaysDate()
                + File.separator + testSuiteName
                + File.separator + testName
                + File.separator + testMethodName
                + File.separator + getSystemTime()
                + " " + fileName + ".png";
        try{
            FileUtils.copyFile(file, new File(path));
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
