package io.github.arasdenizhan.core.validator;

import io.github.arasdenizhan.annotations.*;
import io.github.arasdenizhan.core.exception.ValidationException;
import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlimValidatorTests {

    private final SlimValidator validator = new SlimValidator();

    static class UserDto {
        @NotNull(message = "Name is required!")
        private String name;

        @Min(value = 18, message = "Age must be greater than or equal to 18!")
        private Integer age;

        @Max(value = 1, message = "Country code must be less than or equal to 1!")
        private Integer countryCode;

        @Pattern(value = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        private String email;

        @Email(message = "Another email must fit the email pattern!")
        private String anotherEmail;

        @Length(min = 8, max = 16, message = "Password must be between 8 and 16 characters!")
        private String password;

        @NotBlank(message = "Another string is null.. Wow!")
        private String anotherString;

        public UserDto(String name, Integer age, Integer countryCode, String email, String anotherEmail, String password, String anotherString) {
            this.name = name;
            this.age = age;
            this.countryCode = countryCode;
            this.email = email;
            this.anotherEmail = anotherEmail;
            this.password = password;
            this.anotherString = anotherString;
        }
    }

    @Test
    public void testValidate_Success() {
        UserDto user = getUser("Denizhan24", 18, 1, "email@test.com", "anotherEmail1@test.com", "password", "testAnother");
        Assertions.assertDoesNotThrow(() -> validator.validate(user));
    }

    @Test
    public void testValidate_Fails_WhenNameIsNull() {
        UserDto user = getUser(null, 25, -1, "email2@test.com", "anotherEmail2@test.com", "password2", "testAnother2");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("name: Name is required!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_WhenAgeIsLessThanMin() {
        UserDto user = getUser("Denizhan", 15, -1, "email3@test.com", "anotherEmail3@test.com", "password3", "testAnother3");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("age: Age must be greater than or equal to 18!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_WhenCountryCodeIsGreeterThanMax() {
        UserDto user = getUser("Denizhan1", 18, 3, "email4@test.com", "anotherEmail4@test.com", "password4", "testAnother4");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("countryCode: Country code must be less than or equal to 1!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_WhenEmailNotFitsPattern() {
        UserDto user = getUser("Denizhan2", 18, 1, "email", "anotherEmail5@test.com", "password5", "testAnother5");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("email: Field must follow the pattern!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_WhenAnotherEmailNotAnEmailString() {
        UserDto user = getUser("Denizhan3", 18, 1, "email5@test.com", "anotherEmail", "password6", "testAnother6");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("anotherEmail: Another email must fit the email pattern!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_WhenLengthIsNotGreeterThanMin() {
        UserDto user = getUser("Denizhan4", 18, 1, "email6@test.com", "anotherEmail6@test.com", "pass", "testAnother7");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("password: Password must be between 8 and 16 characters!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_WhenLengthIsNotLessThanMax() {
        UserDto user = getUser("Denizhan5", 18, 1, "email7@test.com", "anotherEmail7@test.com", "passpasspasspasspasspasspasspass", "testAnother8");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("password: Password must be between 8 and 16 characters!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_MultipleFields() {
        UserDto user = getUser(null, 13, -1, "email24", "anotherEmail24", "deniz", "testAnother10");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("name: Name is required!\nage: Age must be greater than or equal to 18!\nemail: Field must follow the pattern!\nanotherEmail: Another email must fit the email pattern!\npassword: Password must be between 8 and 16 characters!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_WhenStringFieldIsNull() {
        UserDto user = getUser("Denizhan24", 18, 1, "email@test.com", "anotherEmail1@test.com", "password", null);

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("anotherString: Another string is null.. Wow!", exception.getMessage());
    }

    @Test
    public void testValidate_Fails_WhenStringFieldIsBlank() {
        UserDto user = getUser("Denizhan24", 18, 1, "email@test.com", "anotherEmail1@test.com", "password", "");

        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(user));

        Assertions.assertEquals("anotherString: Another string is null.. Wow!", exception.getMessage());
    }

    private static UserDto getUser(String name, Integer age, Integer countryCode, String email, String anotherEmail, String password, String anotherString) {
        return new UserDto(name, age, countryCode, email, anotherEmail, password, anotherString);
    }
}
