package categories;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.CategoryForClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetCategoryBySlug {
    @Test
    public void testToGetACategory() {
        String slug = "electronics";
        UserLogin payload = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );
        AuthenticateUser.userLogin(payload);
        Response response = CategoryForClient.getACategory(slug);
        response.then()
                .statusCode(200);

        assertThat(response.jsonPath().getString("success"), equalTo("true"));
    }
}
