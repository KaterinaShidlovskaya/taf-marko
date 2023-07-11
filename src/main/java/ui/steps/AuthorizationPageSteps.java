package ui.steps;

import org.openqa.selenium.WebDriver;
import ui.pages.AuthorizationFormPage;
import ui.pages.HomePage;
import ui.utils.Utils;

public class AuthorizationPageSteps {
    HomePage homePage;
    AuthorizationFormPage authorizationFormPage;


    public AuthorizationPageSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        authorizationFormPage = new AuthorizationFormPage(driver);
    }

    public AuthorizationPageSteps openAuthorizationFormPage() {
        homePage.clickButtonLogin()
                .clickButtonAuthorization();
        return this;
    }

    public AuthorizationPageSteps fillAuthorizationFormWithGeneratedUserData() {
        authorizationFormPage.fillPhoneNumberForm(Utils.generatePhoneNumber())
                .fillPasswordForm(Utils.generatePassword())
                .clickButtonSubmit();
        return this;
    }

    public AuthorizationPageSteps fillAuthorizationFormWithRegisteredUserData() {
        authorizationFormPage.fillPhoneNumberForm(Utils.RegisteredUser.USER_PHONE_NUMBER.toString())
                .fillPasswordForm(Utils.RegisteredUser.USER_PASSWORD.toString())
                .clickButtonSubmit()
                .isPersonalOfficePageDisplayed();
        return this;
    }

    public AuthorizationPageSteps fillAuthorizationFormWithEmptyUserData() {
        authorizationFormPage.fillPhoneNumberForm("")
                .fillPasswordForm("")
                .clickButtonSubmit();
        return this;
    }

    public AuthorizationPageSteps fillAuthorizationFormWithOutPhoneNumber() {
        authorizationFormPage.fillPhoneNumberForm("")
                .fillPasswordForm(Utils.RegisteredUser.USER_PASSWORD.toString())
                .clickButtonSubmit();
        return this;
    }

    public AuthorizationPageSteps fillAuthorizationFormWithOutPassword() {
        authorizationFormPage.fillPhoneNumberForm(Utils.RegisteredUser.USER_PHONE_NUMBER.toString())
                .fillPasswordForm("")
                .clickButtonSubmit();
        return this;
    }

    public AuthorizationPageSteps fillAuthorizationFormWithInvalidPhoneNumber() {
        authorizationFormPage.fillPhoneNumberForm(Utils.generatePhoneNumber())
                .fillPasswordForm(Utils.RegisteredUser.USER_PASSWORD.toString())
                .clickButtonSubmit();
        return this;
    }

    public AuthorizationPageSteps fillAuthorizationFormWithInvalidPassword() {
        authorizationFormPage.fillPhoneNumberForm(Utils.RegisteredUser.USER_PHONE_NUMBER.toString())
                .fillPasswordForm(Utils.generatePassword())
                .clickButtonSubmit();
        return this;
    }
}