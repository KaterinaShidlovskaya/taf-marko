package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.constants.ConstantData.SEARCH_EMPTY_RESULTS;
import static ui.constants.ConstantData.SEARCH_VALID_RESULTS;
import static ui.constants.ConstantData.SEARCH_INVALID_RESULTS;


public class HomePageTests extends BaseUITest {

    @Test
    @DisplayName("Проверка отображения содержимого главной страницы")
    public void testHomePageDisplay() {
        assertAll("Проверка содержимого главной страницы",
                () -> assertTrue(homePage.isLogoDisplayed(),
                        "Логотип не отображается"),
                () -> assertEquals("Контактная информация", homePage.getFooterText(),
                        "Футер 'Контактная инфорация' не отображается")
        );
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' без введения данных")
    public void testSearchBoxWithEmptyData() {
        homePage.fillSearchForm("");
        assertEquals(SEARCH_EMPTY_RESULTS, homePage.getSearchInfoMessage(),
                "Информация о товаре не совпадает с ожидаемой");
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' с корректными данными")
    public void testSearchBoxWithSomeItem() {
        String searchItem = "туфли";
        homePage.fillSearchForm(searchItem);
        assertEquals(SEARCH_VALID_RESULTS + "\"" + searchItem + "\"", homePage.getSearchResultMessage(),
                "Текст о результатах поиска по запросу не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка поля 'Поиск' с некорректными данными")
    public void testSearchBoxWithInvalidData() {
        String searchItem = "@/--//--";
        homePage.fillSearchForm(searchItem);
        assertAll("Проверка содержимого страницы результатов поиска",
                () -> assertEquals(SEARCH_VALID_RESULTS + "\"" + searchItem + "\"", homePage.getSearchResultMessage(),
                        "Текст о результатах поиска по запросу не совпадает с ожидаемым"),
                () -> assertEquals(SEARCH_INVALID_RESULTS, homePage.getSearchInfoMessage(),
                        "Информация о товаре не совпадает с ожидаемой"));
    }
}
