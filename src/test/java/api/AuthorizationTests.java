package api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.constants.Messages.STATUS_ERROR_MESSAGE;
import static api.constants.Messages.STATUS_OK_MESSAGE;
import static api.constants.Users.EMPTY_USER_DATA;
import static api.constants.Users.UNREGISTERED_USER_DATA;
import static api.constants.Users.REGISTERED_USER_DATA;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationTests extends BaseTest {

    @Test
    @DisplayName("Проверка авторизации без введения данных")
    public void testAuthorizingWithEmptyData() {
        validatableResponse = AUTHENTICATION_REQUESTS.authenticateUser(EMPTY_USER_DATA);
        assertAll("Проверка авторизации без введения данных",
                () -> assertEquals(200, validatableResponse.extract().statusCode(),
                        "Статус ответа не совпадает с ожидаемым"),
                () -> assertEquals(STATUS_ERROR_MESSAGE, validatableResponse.extract().asString(),
                        "Сообщение 'Ошибка данных!' не отображается")
        );
    }

    @Test
    @DisplayName("Проверка авторизации незарегистрированного пользователя")
    public void testAuthorizingUserNotRegistered() {
        validatableResponse = AUTHENTICATION_REQUESTS.authenticateUser(UNREGISTERED_USER_DATA);
        assertAll("Проверка авторизации незарегистрированного пользователя",
                () -> assertEquals(200, validatableResponse.extract().statusCode(),
                        "Статус ответа не совпадает с ожидаемым"),
                () -> assertEquals(STATUS_ERROR_MESSAGE, validatableResponse.extract().asString(),
                        "Сообщение 'Ошибка данных!' не отображается")
        );
    }

    @Test
    @DisplayName("Проверка авторизации зарегистрированного пользователя")
    public void testAuthorizingUserRegistered() {
        validatableResponse = AUTHENTICATION_REQUESTS.authenticateUser(REGISTERED_USER_DATA);
        assertAll("Проверка авторизации зарегистрированного пользователя",
                () -> assertEquals(200, validatableResponse.extract().statusCode(),
                        "Статус ответа не совпадает с ожидаемым"),
                () -> assertEquals(STATUS_OK_MESSAGE, validatableResponse.extract().asString(),
                        "Отображается сообщение об ошибке"));
    }
}