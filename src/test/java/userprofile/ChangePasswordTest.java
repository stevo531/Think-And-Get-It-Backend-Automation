package userprofile;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.ChangePasswordPayload;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.UserClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChangePasswordTest {

    @Test
    public void testChangePassword() {

        UserLogin loginPayload = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );

        System.out.println("Logging in...");

        String token = AuthenticateUser
                .userLogin(loginPayload)
                .jsonPath()
                .getString("data.token");

        System.out.println("Got token");

        ChangePasswordPayload passwordPayload =
                new ChangePasswordPayload(
                        TestUserLogin.PASSWORD,
                        "newPassword1234!"
                );

        System.out.println("Changing password...");

        Response response =
                UserClient.changePassword(token, passwordPayload);

        response.prettyPrint();

        response.then()
                .statusCode(200);

        assertThat(
                response.jsonPath().getString("message"),
                equalTo("Password changed")
        );
    }
}