package products;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.ProductForClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GetSingleProductTestBySlug {


    @Test
    public void testGetProductBySlug(){

        UserLogin userLogin = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );

        AuthenticateUser.userLogin(userLogin);


        String slug = "gaming-keyboard";

        Response response =
                ProductForClient.getSingleProductBySlug(slug);

        response.then()
                .statusCode(200);


        assertThat(
                response.jsonPath().getString("message"),
                equalTo("Success")
        );


        assertThat(
                response.jsonPath().getString("data.slug"),
                equalTo(slug)
        );
    }
}