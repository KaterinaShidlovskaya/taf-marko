package api;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;


public class RestTests {
    @Test
    public void testGettingBasePage() {
        String endpoint = "https://www.marko.by/";
        given()
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testGettingAuthorizingForm() {
        String endpoint = "https://www.marko.by/auth/";
        given().header("Content-type", "text/html; charset=UTF-8")
                .when().get(endpoint).then().assertThat().statusCode(200);
    }

    @Test
    public void testAuthorizingWithEmptyData() {
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("form_data", "login=password=");
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        given().when().headers(headers).formParams(formParams).post("https://www.marko.by/ajax/authClient.php")
                .then().log().body();
    }

    @Test
    public void testAuthorizingWithInvalidData() {
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("form_data", "login=%2B375%20(29)%20655-00-09&password=1q2w3e4r");
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("X-Requested-With", "XMLHttpRequest");
        given().when().headers(headers).formParams(formParams).post("https://www.marko.by/ajax/authClient.php").then().log().body();
    }

    @Test
    public void testSearchBoxWithEmptyData() {
        String endpoint = "https://www.marko.by/";
        String searchObject = "";
        given()
                .header("Content-type", "text/html; charset=UTF-8")
                .queryParam("q", searchObject)
                .when()
                .get(endpoint)
                .then()
                .log().body();
    }

    @Test
    public void testSearchBoxWithSomeItem() {
        String endpoint = "https://www.marko.by/";
        String searchObject = "туфли";
        given()
                .header("Content-type", "text/html; charset=UTF-8")
                .queryParam("q", searchObject)
                .when()
                .get(endpoint)
                .then()
                .log().body();
    }
    @Test
    public void testSearchBoxWithInvalidData() {
        String endpoint = "https://www.marko.by/";
        String searchObject = "@/--//--";
        given()
                .header("Content-type", "text/html; charset=UTF-8")
                .queryParam("q", searchObject)
                .when()
                .get(endpoint)
                .then()
                .log().body();
    }
}
