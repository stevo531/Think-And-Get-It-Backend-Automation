package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAddressPayload {

    private String label;
    private String firstName;
    private String lastName;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    @JsonProperty("isDefault")
    private boolean defaultAddress;

    public AddAddressPayload(
            String label,
            String firstName,
            String lastName,
            String phone,
            String street,
            String city,
            String state,
            String country,
            String postalCode,
            boolean defaultAddress) {

        this.label = label;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.defaultAddress = defaultAddress;
    }

    public String getLabel() {
        return label;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }
}