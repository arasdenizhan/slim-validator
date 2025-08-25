package io.github.arasdenizhan.core.validator;

import io.github.arasdenizhan.annotations.Length;
import io.github.arasdenizhan.core.exception.ValidationException;
import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LengthFieldTests {

    private final SlimValidator validator = new SlimValidator();

    static class InvalidDto {
        @Length
        private LocalDate length;

        public InvalidDto(LocalDate date) {
            this.length = date;
        }
    }

    @Test
    public void testValidateWithInvalidFieldType() {
        LengthFieldTests.InvalidDto testDto = new LengthFieldTests.InvalidDto(LocalDate.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertEquals("length: This annotation can only be used on [java.lang.String]", exception.getMessage());
    }
}
