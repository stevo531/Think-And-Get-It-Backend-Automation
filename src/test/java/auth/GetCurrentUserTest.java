package auth;


import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import constants.TestUserLogin;
import payloads.UserLogin;
import user.AuthenticateUser;

import static org.hamcrest.Matchers.equalTo;

    public class GetCurrentUserTest {

        @Test
        public void testGetCurrentUser() {

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

            String token = response.jsonPath().getString("data.token"); // token for the logged in user

            Response meResponse =
                    AuthenticateUser.getUser(token);

            meResponse.then()
                    .statusCode(200)
                    .body("success", equalTo(true))
                    .body("data.user.email",
                            equalTo(TestUserLogin.EMAIL));
        }
    }

