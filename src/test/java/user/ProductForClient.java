package user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.CreateProductPayload;
import payloads.UpdateProductPayload;

import static io.restassured.RestAssured.given;


public class ProductForClient {

    public static Response listProductsByFilterAndPagination(int page, int limit, String slug, int minPrice, int maxPrice, int rating) {
        return given()
                .log().all()
                .queryParam("page", page)
                .queryParam("limit", limit)
                .queryParam("slug", slug)
                .queryParam("minPrice", minPrice)
                .queryParam("maxPrice", maxPrice)

                .when()
                .get("/products")
                .then()
                .log().all()
                .extract()
                .response();


    }

    public static Response createProduct(String token, CreateProductPayload payload){
        return given()

                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()

                .when()
                .post("/products")

                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response getSingleProductBySlug(String slug) {
        return given()
                .pathParam("slug", slug)
                .when()
                .get("/products/{slug}")

                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response updateProduct(
            String token,
            String productId,
            UpdateProductPayload payload
    ){

        return given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(payload)

                .when()
                .put("/products/" + productId)

                .then()
                .log().all()
                .extract()
                .response();
    }
}
