package api;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.BaseTest.Messages.*;

public class SearchTests extends BaseTest {
    private ValidatableResponse validatableResponse;

    @Test
    @DisplayName("Проверка поля 'Поиск' без введения данных")
    public void testSearchBoxWithEmptyData() {
        validatableResponse = SEARCH_REQUESTS.searchForAnItem("");
        Assertions.assertEquals(200, validatableResponse.extract().statusCode());
        String expectedMessage = validatableResponse.extract().asString();
        Assertions.assertTrue(expectedMessage.contains(SEARCH_EMPTY_RESULTS.toString()));
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' с корректными данными")
    public void testSearchBoxWithSomeItem() {
        validatableResponse = SEARCH_REQUESTS.searchForAnItem("туфли");
        Assertions.assertEquals(200, validatableResponse.extract().statusCode());
        String expectedMessage = validatableResponse.extract().asString();
        Assertions.assertTrue(expectedMessage.contains(SEARCH_VALID_RESULTS.toString()));
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' с некорректными данными")
    public void testSearchBoxWithInvalidData() {
        validatableResponse = SEARCH_REQUESTS.searchForAnItem("@/--//--");
        Assertions.assertEquals(200, validatableResponse.extract().statusCode());
        String expectedMessage = validatableResponse.extract().asString();
        Assertions.assertTrue(expectedMessage.contains(SEARCH_INVALID_RESULTS.toString()));
    }
}