package payloads;

public class ForgotPasswordInputs {
    private String email;

    public ForgotPasswordInputs(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
