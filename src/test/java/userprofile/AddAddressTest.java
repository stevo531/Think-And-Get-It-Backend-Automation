package userprofile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.TestUserLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.AddAddressPayload;
import payloads.UserLogin;
import user.AuthenticateUser;
import user.UserClient;

import java.util.ResourceBundle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddAddressTest {

    private AddAddressPayload addAddressPayload;
    @Test
    public void testAddAddress() {

        UserLogin loginPayload = new UserLogin(
                TestUserLogin.EMAIL,
                TestUserLogin.PASSWORD,
                TestUserLogin.USERFIRSTNAME
        );
        String token = AuthenticateUser.userLogin(loginPayload)
                .jsonPath()
                .getString("data.token");
        AddAddressPayload addressPayload =
                new AddAddressPayload(
                        "Home",
                        "Steven",
                        "Smith",
                        "+250788123456",
                        "KG 123 St",
                        "Kigali",
                        "Kigali City",
                        "Rwanda",
                        "00000",
                        true
                );
        Response response = UserClient.addAddress(token, addressPayload);
        response.prettyPrint();
        response.then()
                .statusCode(201);

        assertThat(response.jsonPath().getString("message"), equalTo("Address added"));
    }
}
