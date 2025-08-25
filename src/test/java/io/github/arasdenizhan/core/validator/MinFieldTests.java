package io.github.arasdenizhan.core.validator;

import io.github.arasdenizhan.annotations.Min;
import io.github.arasdenizhan.core.exception.ValidationException;
import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MinFieldTests {

    private final SlimValidator validator = new SlimValidator();

    static class InvalidDto {
        @Min
        private LocalDate min;

        public InvalidDto(LocalDate date) {
            this.min = date;
        }
    }

    @Test
    public void testValidateWithInvalidFieldType() {
        MinFieldTests.InvalidDto testDto = new MinFieldTests.InvalidDto(LocalDate.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertTrue(exception.getMessage().contains("min: This annotation can only be used on"));
    }
}
