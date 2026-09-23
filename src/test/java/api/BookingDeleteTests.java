package api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.ConfigReader;
import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.given;

public class BookingDeleteTests {

    @BeforeAll
    static void setup() {
        baseURI = ConfigReader.get("api.base.url");
    }

    @Test
    void deleteBookingWithValidTokenReturnsSuccess() {
        int bookingId = BookingHelper.createBookingAndGetId();
        String token = AuthHelper.getAuthToken();

        given()
                .cookie("token", token)
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(201);
        ;
    }
}
