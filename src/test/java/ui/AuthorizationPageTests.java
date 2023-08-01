package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import ui.utils.Utils;

import static ui.constants.ConstantData.REGISTERED_PHONE_NUMBER;
import static ui.constants.ConstantData.REGISTERED_PASSWORD;
import static ui.constants.ConstantData.INCORRECT_PHONE_NUMBER_OR_PASSWORD;
import static ui.constants.ConstantData.ENTER_PHONE_NUMBER_PLEASE;
import static ui.constants.ConstantData.ENTER_YOUR_PASSWORD_PLEASE;

public class AuthorizationPageTests extends BaseUITest {

    @BeforeEach
    public void setBeforeEach() {
        homePage.clickButtonKey()
                .clickButtonAuthorization();
    }

    @Test
    @DisplayName("Авторизация зарегистрированного пользователя")
    public void testAuthorizationRegisteredUser() {
        authorizationFormPage.fillPhoneNumberForm(REGISTERED_PHONE_NUMBER)
                .fillPasswordForm(REGISTERED_PASSWORD)
                .clickButtonSubmit();
        Assertions.assertTrue(authorizationFormPage.isPersonalOfficePageDisplayed(),
                "Страница 'Личный кабинет' не отображается");
        homePage.clickButtonKey();
        authorizationFormPage.clickButtonExit();
    }

    @Test
    @DisplayName("Авторизация незарегистрированного пользователя")
    public void testAuthorizationUnregisteredUser() {
        authorizationFormPage.fillPhoneNumberForm(Utils.generatePhoneNumber())
                .fillPasswordForm(Utils.generatePassword())
                .clickButtonSubmit();
        Assertions.assertEquals(INCORRECT_PHONE_NUMBER_OR_PASSWORD, authorizationFormPage.getErrorMessage());
    }

    @Test
    @DisplayName("Авторизация без заполнения полей")
    public void testAuthorizationWithEmptyData() {
        authorizationFormPage.fillPhoneNumberForm("")
                .fillPasswordForm("")
                .clickButtonSubmit();
        Assertions.assertEquals(ENTER_PHONE_NUMBER_PLEASE, authorizationFormPage.getErrorMessage());
    }

    @Test
    @DisplayName("Авторизация без заполения поля 'Телефон'")
    public void testAuthorizationWithOutPhoneNumber() {
        authorizationFormPage.fillPhoneNumberForm("")
                .fillPasswordForm(REGISTERED_PASSWORD)
                .clickButtonSubmit();
        Assertions.assertEquals(ENTER_PHONE_NUMBER_PLEASE,authorizationFormPage.getErrorMessage());
    }

    @Test
    @DisplayName("Авторизация без заполения поля 'Пароль'")
    public void testAuthorizationWithOutPassword() {
        authorizationFormPage.fillPhoneNumberForm(REGISTERED_PHONE_NUMBER)
                .fillPasswordForm("")
                .clickButtonSubmit();
        Assertions.assertEquals(ENTER_YOUR_PASSWORD_PLEASE, authorizationFormPage.getErrorMessage());
    }

    @Test
    @DisplayName("Авторизация с невалидным номером телефона")
    public void testAuthorizationWithAnInvalidPhoneNumber() {
        authorizationFormPage.fillPhoneNumberForm(Utils.generatePhoneNumber())
                .fillPasswordForm(REGISTERED_PASSWORD)
                .clickButtonSubmit();
        Assertions.assertEquals(INCORRECT_PHONE_NUMBER_OR_PASSWORD,authorizationFormPage.getErrorMessage());
    }

    @Test
    @DisplayName("Авторизация с невалидным паролем")
    public void testAuthorizationWithAnInvalidPassword() {
        authorizationFormPage.fillPhoneNumberForm(REGISTERED_PHONE_NUMBER)
                .fillPasswordForm(Utils.generatePassword())
                .clickButtonSubmit();
        Assertions.assertEquals(INCORRECT_PHONE_NUMBER_OR_PASSWORD, authorizationFormPage.getErrorMessage());
    }

    @AfterEach
    public void setAfterEach(){
        authorizationFormPage.clearPhoneNumber().clearPassword();
    }
}