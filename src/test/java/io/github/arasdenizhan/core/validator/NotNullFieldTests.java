package io.github.arasdenizhan.core.validator;

import io.github.arasdenizhan.annotations.NotNull;
import io.github.arasdenizhan.core.exception.ValidationException;
import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class NotNullFieldTests {

    private final SlimValidator validator = new SlimValidator();

    static class InvalidDto {
        @NotNull
        private LocalDate str;

        public InvalidDto(LocalDate date) {
            this.str = date;
        }
    }

    @Test
    public void testValidateWithInvalidFieldType() {
        NotNullFieldTests.InvalidDto testDto = new NotNullFieldTests.InvalidDto(LocalDate.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertEquals("str: This annotation can only be used on [java.lang.String]", exception.getMessage());
    }
}
