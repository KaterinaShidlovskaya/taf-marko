package api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class SearchRequests {

    private String endpoint = "https://www.marko.by/search/";

    private static SearchRequests instance;

    private SearchRequests() {
    }

    public static SearchRequests getInstance() {
        if (instance == null) {
            instance = new SearchRequests();
        }
        return instance;
    }

    public ValidatableResponse searchForAnItem(String searchItem) {
        return given()
                .header("Content-type", "text/html; charset=UTF-8")
                .queryParam("q", searchItem)
                .when()
                .get(endpoint)
                .then();
    }
}