package userprofile;

import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.UserClient;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UploadAvatarTest {

    @Test
    public void testUploadAvatar() {

        UserLogin loginPayload = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );

        String token = AuthenticateUser
                .userLogin(loginPayload)
                .jsonPath()
                .getString("data.token");

        File avatarFile =
                new File("src/test/resources/avatar.jpg");

        Response response =
                UserClient.uploadAvatar(token, avatarFile);

        response.then()
                .statusCode(200);

        assertThat(
                response.jsonPath().getString("message"),
                equalTo("Avatar updated")
        );
    }
}