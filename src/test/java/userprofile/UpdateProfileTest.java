package userprofile;


import constants.TestUserLogin;
import payloads.UserLogin;
import user.UserClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.UpdateProfilePayload;
import user.AuthenticateUser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateProfileTest {

    @Test
    public void testUpdateProfile() {

        UserLogin payload = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );

        System.out.println("About to update profile...");

        String token = AuthenticateUser
                .userLogin(payload)
                .jsonPath()
                .getString("data.token");

        UpdateProfilePayload userPayload =
                new UpdateProfilePayload(
                        "Steven",
                        "Smith",
                        "+250788123456"
                );

        System.out.println("Got token: " + token);

        System.out.println("Calling updateProfile...");

        Response response =
                UserClient.updateProfile(token, userPayload);

        System.out.println("Update profile response received");

        response.then()
                .statusCode(200);

        assertThat(
                response.jsonPath().getString("message"),
                equalTo("Profile updated")
        );
    }
}
