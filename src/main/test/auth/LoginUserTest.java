package auth;

import constants.TestUserLogin;
import constants.TestUsersRegistration;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.RegisterUser;
import payloads.UserLogin;
import user.AuthenticateUser;

import static org.hamcrest.Matchers.equalTo;

public class LoginUserTest {

    @Test
    public void testLogin() {
        UserLogin payload = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );


        var response = AuthenticateUser.userLogin(payload);

        response.then()
                .log().all()
                .statusCode(200)
                .body("data.user.email", equalTo(TestUserLogin.EMAIL))
                .body("data.user.firstName", equalTo(TestUserLogin.USERFIRSTNAME));

    }
}
