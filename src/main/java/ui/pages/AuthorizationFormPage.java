package ui.pages;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationFormPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@name='login']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//*[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[@type='button' and text()='Войти']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//*[@class='breadcrumbs__item' and text()='Личный кабинет']")
    private WebElement personalOfficePage;

    public AuthorizationFormPage(WebDriver driver) {
        this.driver = driver;
    }

    @Description("Заполнением поле 'Телефон'")
    public AuthorizationFormPage fillPhoneNumberForm(String phoneNumber) {
        inputPhoneNumber.sendKeys(phoneNumber);
        return this;
    }

    @Description("Заполнением поле 'Пароль'")
    public AuthorizationFormPage fillPasswordForm(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Description("Нажимаем на кнопку 'Войти'")
    public AuthorizationFormPage clickButtonSubmit() {
        buttonSubmit.click();
        return this;
    }

    @Description("Отбражается страница 'Личный кабинет'")
    public AuthorizationFormPage isPersonalOfficePageDisplayed() {
        personalOfficePage.isDisplayed();
        return this;
    }
}