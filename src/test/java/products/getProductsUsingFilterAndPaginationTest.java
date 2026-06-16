package products;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.ProductForClient;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class getProductsUsingFilterAndPaginationTest {

    @Test
    public void testUsingFiltersAndPagination() {
        UserLogin payloads = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.USERFIRSTNAME,
                TestUserLogin.PASSWORD
        );
        AuthenticateUser.userLogin(payloads);

        Response response = ProductForClient.listProductsByFilterAndPagination(10,15,
                "womens-fashion", 20,100, 8);
        response.then()
                .statusCode(200);

        List<String> slugs= response.jsonPath().getList("data.category.slug");

        for(String slug : slugs ) {
            assertThat(slug, equalTo(slug));
        }

    }
}
