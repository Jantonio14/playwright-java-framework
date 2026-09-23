package api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PingTests {

    @BeforeAll
    static void setup() {
        baseURI = ConfigReader.get("api.base.url");
    }


    @Test
    void healthCheckReturnsCreated() {
        given()
                .when()
                    .get("/ping")
                .then()
                    .statusCode(201);
    }
}
