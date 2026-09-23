package api;

import io.restassured.http.ContentType;
import utils.ConfigReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AuthHelper {

    public static String getAuthToken() {
        baseURI = ConfigReader.get("api.base.url");

        String requestBody = """
            {
                "username": "admin",
                "password": "password123"
            }
            """;

        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}
