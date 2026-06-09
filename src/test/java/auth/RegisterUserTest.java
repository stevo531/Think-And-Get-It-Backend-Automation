package auth;

import constants.TestUsersRegistration;
import constants.TestUsersRegistration;
import org.testng.annotations.Test;
import payloads.RegisterUser;
import user.AuthenticateUser;

import static org.hamcrest.Matchers.equalTo;


public class RegisterUserTest {

    @Test
    public void testRegisterUserSuccessfully() {

        RegisterUser payload = new RegisterUser(
                TestUsersRegistration.FIRST_NAME,
                TestUsersRegistration.LAST_NAME,
                TestUsersRegistration.EMAIL,
                TestUsersRegistration.PASSWORD,
                TestUsersRegistration.PHONE
        );

        var response = AuthenticateUser.registerUser(payload);

        response.then()
                .log().all()
                .statusCode(201)
                .body("user.email", equalTo(TestUsersRegistration.EMAIL))
                .body("user.firstName", equalTo(TestUsersRegistration.FIRST_NAME))
                .body("user.lastName", equalTo(TestUsersRegistration.LAST_NAME));
    }
}
