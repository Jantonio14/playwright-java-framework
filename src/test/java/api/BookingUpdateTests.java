package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingUpdateTests {

    @BeforeAll
    static void setup() {
        baseURI = ConfigReader.get("api.base.url");
    }

    @Test
    void updateBookingWithValidTokenReturnsUpdatedData() {
        String token = AuthHelper.getAuthToken();

        String updateBody = """
            {
                "firstname": "UpdatedFirstName",
                "lastname": "UpdatedLastName",
                "totalprice": 200,
                "depositpaid": false,
                "bookingdates": {
                    "checkin": "2026-02-01",
                    "checkout": "2026-02-10"
                },
                "additionalneeds": "Lunch"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .body(updateBody)
                .when()
                .put("/booking/1")
                .then()
                .statusCode(200)
                .body("firstname", equalTo("UpdatedFirstName"))
                .body("totalprice", equalTo(200));
    }
}