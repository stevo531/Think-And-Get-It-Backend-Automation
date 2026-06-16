package user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.CreateCategoryPayload;

import static io.restassured.RestAssured.given;

public class CategoryForClient {
    private String token;

    public static Response getCategories(String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("categories")
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response createCategory(String token,CreateCategoryPayload payload) {
        return given()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("categories")
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response getACategory(String slug) {
        return given()
                .pathParam("slug", slug)
                .when()
                .get("/categories/{slug}")
                .then()
                .log().all()
                .extract()
                .response();

    }
}
