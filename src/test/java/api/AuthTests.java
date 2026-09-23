package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthTests {

    @BeforeAll
    static void setup() {
        baseURI = ConfigReader.get("api.base.url");
    }

    @Test
    void createTokenWithValidCredentialsReturnsToken() {
        String requestBody = """
    {
        "username": "admin",
        "password": "password123"
    }
    """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }
}
