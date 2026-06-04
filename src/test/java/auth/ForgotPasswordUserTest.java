package auth;

import constants.TestForgottenPassword;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.ForgotPasswordInputs;
import user.AuthenticateUser;
import static org.hamcrest.Matchers.equalTo;

public class ForgotPasswordUserTest {

    @Test
    public void testForgotPassword() {

        ForgotPasswordInputs payload =
                new ForgotPasswordInputs(TestForgottenPassword.EMAILRESET);

        Response response =
                AuthenticateUser.ForgotUserPassword(payload);

        response.then()
                .log().all()
                .statusCode(200)
                .body("message", equalTo("If an account with that email exists, a reset link has been sent."));
    }
}
