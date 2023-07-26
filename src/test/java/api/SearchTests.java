package api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.constants.Messages.SEARCH_EMPTY_RESULTS;
import static api.constants.Messages.SEARCH_VALID_RESULTS;
import static api.constants.Messages.SEARCH_INVALID_RESULTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SearchTests extends BaseTest {

    @Test
    @DisplayName("Проверка поля 'Поиск' без введения данных")
    public void testSearchBoxWithEmptyData() {
        validatableResponse = SEARCH_REQUESTS.searchForAnItem("");
        String actualResponse = validatableResponse.extract().asString();
        assertAll("Проверка поля 'Поиск' без введения данных",
                () -> assertEquals(200, validatableResponse.extract().statusCode(),
                        "Статус ответа не совпадает с ожидаемым"),
                () -> assertTrue(actualResponse.contains(SEARCH_EMPTY_RESULTS),
                        "Сообщение 'Пустой поисковый запрос' не отображается"));
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' с корректными данными")
    public void testSearchBoxWithSomeItem() {
        validatableResponse = SEARCH_REQUESTS.searchForAnItem("туфли");
        String actualResponse = validatableResponse.extract().asString();
        assertAll("Проверка поля 'Поиск' с корректными данными",
                () -> assertEquals(200, validatableResponse.extract().statusCode(),
                        "Статус ответа не совпадает с ожидаемым"),
                () -> assertTrue(actualResponse.contains(SEARCH_VALID_RESULTS),
                        "Сообщение 'Результаты поиска по запросу' не отображается"));
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' с некорректными данными")
    public void testSearchBoxWithInvalidData() {
        validatableResponse = SEARCH_REQUESTS.searchForAnItem("@/--//--");
        String actualResponse = validatableResponse.extract().asString();
        assertAll("Проверка поля 'Поиск' с корректными данными",
                () -> assertEquals(200, validatableResponse.extract().statusCode(),
                        "Статус ответа не совпадает с ожидаемым"),
                () -> assertTrue(actualResponse.contains(SEARCH_INVALID_RESULTS),
                        "Сообщение 'По данному запросу ничего не найдено' не отображается"));
    }
}