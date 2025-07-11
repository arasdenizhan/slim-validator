package io.github.arasdenizhan.example.dto;

import io.github.arasdenizhan.annotations.*;

public class UserDto {
    @NotNull(message = "Name is required!")
    private String name;

    @NotNull
    private String surname;

    @Min(value = 18, message = "Age must be greater than or equal to 18!")
    private int age;

    @Max(value = 1, message = "Country code must be less than or equal to 1!")
    private int countryCode;

    @Pattern(value = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @Email(message = "Another email must fit the email pattern!")
    private String anotherEmail;

    @Length(min = 8, max = 16, message = "Password must be between 8 and 16 characters!")
    private String password;

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
