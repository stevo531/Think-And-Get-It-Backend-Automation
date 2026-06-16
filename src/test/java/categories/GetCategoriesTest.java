package categories;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.CategoryForClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetCategoriesTest {

    @Test
    public void testToGetCategories() {
        UserLogin userLoginInputs = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );
        String token = AuthenticateUser.
                userLogin(userLoginInputs).
                jsonPath().
                getString("data.token");

        Response response = CategoryForClient.getCategories(token);

        response.then()
                .statusCode(200);

        assertThat(response.jsonPath().getString("message"), equalTo("Success"));
    }
}
