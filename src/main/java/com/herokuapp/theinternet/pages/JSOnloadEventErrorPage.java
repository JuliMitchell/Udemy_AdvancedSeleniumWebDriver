package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class JSOnloadEventErrorPage extends BasePage {
    public JSOnloadEventErrorPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public boolean checkSeveralErrorExist(List<LogEntry> logs){
        for (LogEntry logEntry : logs){
            if(logEntry.getLevel().toString().equals("SEVERE")){
                return true;
            }
        }
        return false;
    }
}
