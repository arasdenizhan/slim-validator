package io.github.arasdenizhan.core.validator;

import io.github.arasdenizhan.annotations.Max;
import io.github.arasdenizhan.core.exception.ValidationException;
import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MaxFieldTests {

    private final SlimValidator validator = new SlimValidator();

    static class InvalidDto {
        @Max
        private LocalDate max;

        public InvalidDto(LocalDate date) {
            this.max = date;
        }
    }

    @Test
    public void testValidateWithInvalidFieldType() {
        MaxFieldTests.InvalidDto testDto = new MaxFieldTests.InvalidDto(LocalDate.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertEquals("max: This annotation can only be used on [int, java.lang.Integer]", exception.getMessage());
    }
}
