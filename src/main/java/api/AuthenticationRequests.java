package api;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AuthenticationRequests {
    private String endpointAuthorizationForm = "https://www.marko.by/ajax/authClient.php";
    private static AuthenticationRequests instance;

    private AuthenticationRequests() {
    }

    public static AuthenticationRequests getInstance() {
        if (instance == null) {
            instance = new AuthenticationRequests();
        }
        return instance;
    }

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        return headers;
    }

    public ValidatableResponse authenticateUser(String body) {
        return given()
                .when()
                .headers(getHeaders())
                .body(body)
                .post(endpointAuthorizationForm)
                .then();
    }
}