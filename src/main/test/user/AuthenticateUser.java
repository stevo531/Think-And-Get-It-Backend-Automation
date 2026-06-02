package user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.RegisterUser;
import payloads.UserLogin;

import static io.restassured.RestAssured.given;

public class AuthenticateUser {

    static {
        RestAssured.baseURI =
                "https://think-and-get-it-production.up.railway.app/api/v1";
    }

    public static Response registerUser(RegisterUser payload) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth/register")
                .then()
                .log().all()
                .extract()
                .response();
    }
    public static Response userLogin(UserLogin payload) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth/login")
                .then()
                .log().all()
                .extract()
                .response();
    }
}