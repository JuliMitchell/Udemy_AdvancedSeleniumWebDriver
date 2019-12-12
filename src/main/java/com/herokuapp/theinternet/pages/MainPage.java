package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private String url = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By jsAlertLinkLocator = By.linkText("JavaScript Alerts");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private By WYSIWYGEditorLinkLocator = By.linkText("WYSIWYG Editor");
    private By keyPressesLinkLocator = By.linkText("Key Presses");
    private By fileUploadLinkLocator = By.linkText("File Upload");
    private By infiniteScrollLinkLocator = By.linkText("Infinite Scroll");
    private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
    private By hoversLinkLocator = By.linkText("Hovers");

    public MainPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void openPage(){
        log.info("Opening page: " + url);
        openUrl(url);
        log.info("Page opened!");
    }

    public LoginPage clickFormAuthenticationLink(){
        log.info("Clicking Form Authentication link on Main Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckboxesLink(){
        log.info("Clicking Checkboxes link on Main Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdownLink(){
        log.info("Clicking Dropdown link on Main Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    public JSAlertPage clickJSAlertLink(){
        log.info("Clicking JavaScript Alerts link on Main Page");
        click(jsAlertLinkLocator);
        return new JSAlertPage(driver, log);
    }

    public WindowsPage clickMultipleWindowsLink(){
        log.info("Clicking Multiple Windows link on Main Page");
        click(multipleWindowsLinkLocator);
        return new WindowsPage(driver, log);
    }

    public IFramePage clickWYSIWYGEditorLink(){
        log.info("Clicking WYSIWYG Editor link on Main Page");
        click(WYSIWYGEditorLinkLocator);
        return new IFramePage(driver, log);
    }

    public KeyPressesPage clickKeyPressesLink(){
        log.info("Clicking Key Presses link on Main Page");
        click(keyPressesLinkLocator);
        return new KeyPressesPage(driver, log);
    }

    public FileUploaderPage clickFileUploadLink(){
        log.info("Clicking File Upload link on Main Page");
        click(fileUploadLinkLocator);
        return new FileUploaderPage(driver, log);
    }

    public InfiniteScrollPage clickInfiniteScrollLink(){
        log.info("Clicking Infinite Scroll link on Main Page");
        click(infiniteScrollLinkLocator);
        return new InfiniteScrollPage(driver, log);
    }

    public DragAndDropPage clickDragAndDropLink(){
        log.info("Clicking Drag and Drop link on Main Page");
        click(dragAndDropLinkLocator);
        return new DragAndDropPage(driver, log);
    }

    public HoversPage clickHoversLink(){
        log.info("Clicking Hovers link on the Main Page");
        click(hoversLinkLocator);
        return new HoversPage(driver, log);
    }
}
