package categories;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.CreateCategoryPayload;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.CategoryForClient;
import user.UserClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateCategoryTest {

    @Test
    public void testToCreateCategory() {
        UserLogin payload = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );

    String token  = AuthenticateUser.userLogin(payload)
            .jsonPath()
            .getString("data.token");

        CreateCategoryPayload createCategoryPayload = new CreateCategoryPayload("Plots", "Plots for sell", null);
    Response response = CategoryForClient.createCategory(token, createCategoryPayload);

    response.then()
            .statusCode(201);

            assertThat(response.jsonPath().getString("message"), equalTo("Category created"));
    }

}
