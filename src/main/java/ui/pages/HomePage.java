package ui.pages;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    private String baseURL = "https://www.marko.by/";
    @FindBy(xpath = "//*[@class='header-assets__logo-inner']")
    private WebElement logoMarko;
    @FindBy(xpath = "//*[@id='search']")
    private WebElement searchFormField;
    @FindBy(xpath = "//input[contains(@value,'Поиск')]")
    private WebElement buttonSearch;
    @FindBy(xpath = "//*[text()='Контактная информация']")
    private WebElement footerContactInfo;
    @FindBy(xpath = "//*[@class='btn-login-js']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//*[text()='Авторизация']")
    private WebElement buttonAuthorization;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Description("Открываем главную страницу")
    public HomePage getHomePage() {
        driver.get(baseURL);
        return this;
    }

    @Description("Отображение логотипа 'Marko'")
    public boolean isLogoDisplayed() {
        return logoMarko.isDisplayed();
    }

    @Description("Заполнением поле 'Поиск'")
    public HomePage fillSearchForm(String searchItem) {
        searchFormField.sendKeys(searchItem);
        return this;
    }

    @Description("Нажимаем на кнопку 'Поиск'")
    public HomePage clickButtonSearch() {
        buttonSearch.click();
        return this;
    }

    @Description("Получаем текст 'Контактная информация'")
    public String getFooterText() {
        return footerContactInfo.getText();
    }

    @Description("Нажимаем на кнопку с иконкой 'Ключ'")
    public HomePage clickButtonLogin() {
        buttonSearch.click();
        return this;
    }

    @Description("Нажимаем на кнопку авторизации")
    public HomePage clickButtonAuthorization() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(buttonAuthorization)).click();
        return this;
    }
}