package products;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.*;
import user.AuthenticateUser;
import user.ProductForClient;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CreateProductTest {


    @Test
    public void testCreateProduct(){


        UserLogin loginPayload = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );


        String token = AuthenticateUser
                .userLogin(loginPayload)
                .jsonPath()
                .getString("data.token");


        ProductVariantPayload variant =
                new ProductVariantPayload(
                        "Large",
                        "Black",
                        "#000000",
                        "SKU-001",
                        50,
                        100
                );


        CreateProductPayload productPayload =
                new CreateProductPayload(

                        "Gaming Keyboard",
                        "Mechanical RGB keyboard",
                        120,
                        150,

                        // use an existing category UUID
                        "ddb77290-34ef-4e20-a19b-febca2c5c9d1",

                        List.of(
                                "gaming",
                                "electronics"
                        ),

                        true,
                        false,
                        0,

                        List.of(variant)
                );


        Response response =
                ProductForClient.createProduct(
                        token,
                        productPayload
                );


        response.then()
                .statusCode(201);


        assertThat(
                response.jsonPath().getString("message"),
                equalTo("Product created")
        );

    }
}