package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;
import utils.TestDataGenerator;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class BookingCreateTests {

    @BeforeAll
    static void setup() {
        baseURI = ConfigReader.get("api.base.url");
    }

    @Test
    void createBookingReturnsNewBookingWithId() {
        String requestBody = """
            {
                "firstname": "%s",
                "lastname": "%s",
                "totalprice": 150,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2026-01-01",
                    "checkout": "2026-01-10"
                },
                "additionalneeds": "Breakfast"
            }
            """.formatted(TestDataGenerator.randomFirstName(), TestDataGenerator.randomLastName());

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .body("bookingid", notNullValue())
                .body("booking.firstname", notNullValue());
    }
}
