package user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.AddAddressPayload;
import payloads.ChangePasswordPayload;
import payloads.UpdateProfilePayload;

import java.io.File;

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
    public static Response changePassword(
            String token,
            ChangePasswordPayload payload) {

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(payload)

                .when()
                .put("/users/change-password")

                .then()
                .extract()
                .response();
    }

    public static Response getAddresses(String token) {

        return given()
                .header("Authorization", "Bearer " + token)

                .when()
                .get("/users/addresses")

                .then()
                .extract()
                .response();
    }

    public static Response addAddress(String token,
                                      AddAddressPayload payload) {
        return given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(payload)

                .when()
                .post("/users/addresses")

                .then()
                .extract()
                .response();

    }

    public static Response uploadAvatar(String token, File avatarFile) {

        return given()
                .header("Authorization", "Bearer " + token)
                .multiPart("avatar", avatarFile)
                .when()
                .post("/users/avatar")
                .then()
                .log().all()
                .extract()
                .response();
    }
}