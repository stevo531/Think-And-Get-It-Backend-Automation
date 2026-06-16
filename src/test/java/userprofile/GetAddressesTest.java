package userprofile;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.UserClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAddressesTest {

    @Test
    public void testGetAddresses() {

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

        System.out.println("Getting addresses...");

        Response response =
                UserClient.getAddresses(token);

        response.prettyPrint();

        response.then()
                .statusCode(200);

        assertThat(
                response.jsonPath().getString("message"),
                equalTo("List of addresses")
        );
    }
}