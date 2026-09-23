package api;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class BookingHelper {

    public static int createBookingAndGetId() {
        String requestBody = """
            {
                "firstname": "Temp",
                "lastname": "Booking",
                "totalprice": 100,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2026-03-01",
                    "checkout": "2026-03-05"
                },
                "additionalneeds": "None"
            }
            """;

        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid");
    }
}
