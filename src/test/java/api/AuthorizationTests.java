package api;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.BaseTest.Messages.*;
import static api.BaseTest.Users.*;

public class AuthorizationTests extends BaseTest {
    private ValidatableResponse validatableResponse;

    @Test
    @DisplayName("Проверка авторизации без введения данных")
    public void testAuthorizingWithEmptyData() {
        validatableResponse = AUTHENTICATION_REQUESTS.authenticateUser(EMPTY_USER_DATA.toString());
        Assertions.assertEquals(200, validatableResponse.extract().statusCode());
        Assertions.assertEquals(validatableResponse.extract().asString(), STATUS_ERROR_MESSAGE.toString());
    }

    @Test
    @DisplayName("Проверка авторизации незарегистрированного пользователя")
    public void testAuthorizingUserNotRegistered() {
        validatableResponse = AUTHENTICATION_REQUESTS.authenticateUser(UNREGISTERED_USER_DATA.toString());
        Assertions.assertEquals(200, validatableResponse.extract().statusCode());
        Assertions.assertEquals(validatableResponse.extract().asString(), STATUS_ERROR_MESSAGE.toString());
    }

    @Test
    @DisplayName("Проверка авторизации зарегистрированного пользователя")
    public void testAuthorizingUserRegistered() {
        validatableResponse = AUTHENTICATION_REQUESTS.authenticateUser(REGISTERED_USER_DATA.toString());
        Assertions.assertEquals(200, validatableResponse.extract().statusCode());
        Assertions.assertEquals(validatableResponse.extract().asString(), STATUS_OK_MESSAGE.toString());
    }
}