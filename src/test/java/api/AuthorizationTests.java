package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationTests extends BaseTest {
    @Test
    @DisplayName("Проверка авторизации без введения данных")
    public void testAuthorizingWithEmptyData() {
        String response = AUTHENTICATION_REQUESTS.authenticateUser("login=password=")
                .assertThat().statusCode(200).extract().asString();
        Assertions.assertTrue(response.contains("\\u041e\\u0448\\u0438\\u0431\\u043a\\u0430 \\u0434\\u0430\\u043d\\u043d\\u044b\\u0445!"));
    }

    @Test
    @DisplayName("Проверка авторизации незарегистрированного пользователя")
    public void testAuthorizingUserNotRegistered() {
        String response = AUTHENTICATION_REQUESTS.authenticateUser("login=%2B375%20(29)%20655-00-09&password=1q2w3e4r")
                .assertThat().statusCode(200).extract().asString();
        Assertions.assertTrue(response.contains("\"status\":\"error\""));

    }

    @Test
    @DisplayName("Проверка авторизации зарегистрированного пользователя")
    public void testAuthorizingUserRegistered() {
        String response = AUTHENTICATION_REQUESTS.authenticateUser("form_data=login%3D%252B375%2520(29)%2520510-93-19%26password%3DKaterina1993510")
                .assertThat().statusCode(200).extract().asString();
        Assertions.assertTrue(response.contains("{\"status\":\"ok\"}"));
    }
}