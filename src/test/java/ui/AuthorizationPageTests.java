package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationPageTests extends BaseTest {

    @Test
    @DisplayName("Авторизация зарегистрированного пользователя")
    public void testAuthorizationRegisteredUser() {
        authorizationPageSteps.openAuthorizationFormPage()
                .fillAuthorizationFormWithRegisteredUserData();
    }

    @Test
    @DisplayName("Авторизация незарегистрированного пользователя")
    public void testAuthorizationUnregisteredUser() {
        authorizationPageSteps.fillAuthorizationFormWithGeneratedUserData();
    }

    @Test
    @DisplayName("Авторизация без заполнения полей")
    public void testAuthorizationWithEmptyData() {
        authorizationPageSteps.fillAuthorizationFormWithEmptyUserData();
    }

    @Test
    @DisplayName("Авторизация без заполения поля 'Телефон'")
    public void testAuthorizationWithOutPhoneNumber() {
        authorizationPageSteps.fillAuthorizationFormWithOutPhoneNumber();
    }

    @Test
    @DisplayName("Авторизация без заполения поля 'Пароль'")
    public void testAuthorizationWithOutPassword() {
        authorizationPageSteps.fillAuthorizationFormWithOutPassword();
    }

    @Test
    @DisplayName("Авторизация с невалидным номером телефона")
    public void testAuthorizationWithAnInvalidPhoneNumber() {
        authorizationPageSteps.fillAuthorizationFormWithInvalidPhoneNumber();
    }

    @Test
    @DisplayName("Авторизация с невалидным паролем")
    public void testAuthorizationWithAnInvalidPassword() {
        authorizationPageSteps.fillAuthorizationFormWithInvalidPassword();
    }
}