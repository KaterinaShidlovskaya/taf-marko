package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    protected static final String MAIN_PAGE_URL = "https://www.marko.by/";

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void startMarko() {
        driver.get(MAIN_PAGE_URL);
    }
}
