package api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class BookingReadTests {

    @BeforeAll
    static void setup() {
        baseURI = ConfigReader.get("api.base.url");
    }

    @Test
    void getBookingByIdReturnsValidBooking() {
        given()
                .when()
                    .get("/booking/1")
                .then()
                    .statusCode(200)
                    .body("firstname", notNullValue())
                    .body("lastname", notNullValue())
                    .body("totalprice", notNullValue());
    }

    @Test
    void getAllBookingsReturnsNonEmptyList() {
        given()
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .body("size()", org.hamcrest.Matchers.greaterThan(0));
    }
}
