package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTests extends BaseTest {

    @Test
    @DisplayName("Проверка поля 'Поиск' без введения данных")
    public void testSearchBoxWithEmptyData() {
        String response = SEARCH_REQUESTS.searchForAnItem("")
                .assertThat().statusCode(200).extract().asString();
        Assertions.assertTrue(response.contains("Пустой поисковый запрос"));
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' с корректными данными")
    public void testSearchBoxWithSomeItem() {
        String response = SEARCH_REQUESTS.searchForAnItem("туфли")
                .assertThat().statusCode(200).extract().asString();
        Assertions.assertTrue(response.contains("Результаты поиска по запросу"));
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' с некорректными данными")
    public void testSearchBoxWithInvalidData() {
        String response = SEARCH_REQUESTS.searchForAnItem("@/--//--")
                .assertThat().statusCode(200).extract().asString();
        Assertions.assertTrue(response.contains("По данному запросу ничего не найдено"));
    }
}