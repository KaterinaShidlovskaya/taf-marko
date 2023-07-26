package ui.pages;

import jdk.jfr.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class ='logo']")
    private WebElement logoMarko;
    @FindBy(xpath = "//*[@id='search']")
    private WebElement searchFormField;
    @FindBy(xpath = "//*[text()='Контактная информация']")
    private WebElement footerContactInfo;
    @FindBy(xpath = "//a[@class='btn-login-js']")
    private WebElement buttonKey;
    @FindBy(xpath = "//a[@href='/auth/']")
    private WebElement buttonAuthorization;
    @FindBy(xpath = "//div[@class='catalog__main']//h3")
    private WebElement searchResultMessage;
    @FindBy(xpath = "//div[@class='catalog__main']//i")
    private WebElement searchInfoMessage;
    @FindBy(xpath = "//div[contains(@class,'quiz_close')]")
    private WebElement buttonQuizClose;
    @FindBy(id = "c-p-bn")
    private WebElement buttonCookies;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Description("Отображение логотипа 'Marko'")
    public boolean isLogoDisplayed() {
        return logoMarko.isDisplayed();
    }

    @Description("Заполнением поле 'Поиск'")
    public HomePage fillSearchForm(String searchItem) {
        searchFormField.sendKeys(searchItem + Keys.ENTER);
        return this;
    }

    @Description("Получаем сообщение о результатах поискового запроса")
    public String getSearchResultMessage(){
        return searchResultMessage.getText();
    }

    @Description("Получаем информационное сообщение поискового запроса")
    public String getSearchInfoMessage(){
        return searchInfoMessage.getText();
    }

    @Description("Получаем текст 'Контактная информация'")
    public String getFooterText() {
        return footerContactInfo.getText();
    }

    @Description("Нажимаем на кнопку с иконкой 'Ключ'")
    public HomePage clickButtonKey() {
        buttonKey.click();
        return this;
    }

    @Description("Нажимаем на кнопку авторизации")
    public HomePage clickButtonAuthorization() {
        buttonAuthorization.click();
        return this;
    }

    public HomePage clickButtonQuizClose() {
        buttonQuizClose.click();
        return this;
    }

    public void clickButtonCookie() {
        buttonCookies.click();
    }
}