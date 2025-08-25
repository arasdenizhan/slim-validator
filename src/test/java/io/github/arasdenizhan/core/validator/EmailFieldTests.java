package io.github.arasdenizhan.core.validator;

import io.github.arasdenizhan.annotations.Email;
import io.github.arasdenizhan.core.exception.ValidationException;
import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmailFieldTests {

    private final SlimValidator validator = new SlimValidator();

    static class InvalidDto {
        @Email
        private LocalDate email;

        public InvalidDto(LocalDate date) {
            this.email = date;
        }
    }

    @Test
    public void testValidateWithInvalidFieldType() {
        EmailFieldTests.InvalidDto testDto = new EmailFieldTests.InvalidDto(LocalDate.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertEquals("email: This annotation can only be used on [java.lang.String]", exception.getMessage());
    }
}
