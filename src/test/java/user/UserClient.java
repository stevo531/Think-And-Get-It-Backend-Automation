package user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.UpdateProfilePayload;

import static io.restassured.RestAssured.given;

public class UserClient {

    public static Response updateProfile(
            String token,
            UpdateProfilePayload payload) {

        return given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(payload)

                .when()
                .put("/users/profile")

                .then()
                .log().all()
                .extract()
                .response();
    }
}