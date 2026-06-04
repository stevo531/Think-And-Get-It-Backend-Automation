package payloads;

public class UserLogin {
private String userEmail;
private String password;
private String firstName;

    public UserLogin(String userEmail, String password, String firstName) {
        this.userEmail = userEmail;
        this.password = password;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }
}
