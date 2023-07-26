package ui.pages;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationFormPage extends BasePage {

    @FindBy(xpath = "//*[@name='login']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//*[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[contains(@class,'button_red')]")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//*[@class='breadcrumbs__item' and text()='Личный кабинет']")
    private WebElement personalOfficePage;
    @FindBy(xpath = "//a[@href='/out.php?to=/personal/']")
    private WebElement buttonExit;
    @FindBy(xpath = "//p[contains(@class,'error')]")
    private WebElement errorMessage;

    public AuthorizationFormPage(WebDriver driver) {
        super(driver);
    }

    @Description("Заполнением поле 'Телефон'")
    public AuthorizationFormPage fillPhoneNumberForm(String phoneNumber) {
        inputPhoneNumber.click();
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
    public boolean isPersonalOfficePageDisplayed() {
        return personalOfficePage.isDisplayed();
    }

    @Description("Нажимаем на кнопку 'Выход'")
    public AuthorizationFormPage clickButtonExit() {
        buttonExit.click();
        return this;
    }

    @Description("Получаем текст об ошибке")
    public String getErrorMessage(){
       return errorMessage.getText();
    }

    @Description("Удаляем данные из полей")
    public AuthorizationFormPage clearPhoneNumber(){
        inputPhoneNumber.clear();
        return this;
    }

    @Description("Удаляем данные из полей")
    public AuthorizationFormPage clearPassword(){
        inputPassword.clear();
        return this;
    }
}