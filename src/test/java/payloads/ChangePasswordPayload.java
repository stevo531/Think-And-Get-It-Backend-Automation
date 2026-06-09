package payloads;

public class ChangePasswordPayload {

    private String currentPassword;
    private String newPassword;

    public ChangePasswordPayload(String currentPassword, String newPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}