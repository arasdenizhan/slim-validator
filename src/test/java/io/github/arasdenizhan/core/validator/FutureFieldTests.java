package io.github.arasdenizhan.core.validator;

import io.github.arasdenizhan.annotations.Future;
import io.github.arasdenizhan.core.exception.ValidationException;
import io.github.arasdenizhan.core.validator.impl.SlimValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FutureFieldTests {

    private final SlimValidator validator = new SlimValidator();

    static class CorrectTestDto {
        @Future("2045-08-21")
        private LocalDate date;

        public CorrectTestDto(LocalDate date) {
            this.date = date;
        }
    }

    static class WrongTestDto {
        @Future("2045.08.21")
        private LocalDate date;

        public WrongTestDto(LocalDate date) {
            this.date = date;
        }
    }

    static class InvalidDto {
        @Future("1980.08.21")
        private String date;

        public InvalidDto(String date) {
            this.date = date;
        }
    }

    @Test
    public void testValidate() {
        FutureFieldTests.CorrectTestDto testDto = new FutureFieldTests.CorrectTestDto(LocalDate.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertEquals("date: Date must be greater than => 2045-08-21", exception.getMessage());
    }

    @Test
    public void testValidateWithNullValue() {
        FutureFieldTests.CorrectTestDto testDto = new FutureFieldTests.CorrectTestDto(null);
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertEquals("date: Field value is null!", exception.getMessage());
    }

    @Test
    public void testValidateWithWrongDateFormat() {
        FutureFieldTests.WrongTestDto testDto = new FutureFieldTests.WrongTestDto(LocalDate.now());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertEquals("date: Date format supplied to annotation is wrong!", exception.getMessage());
    }

    @Test
    public void testValidateWithInvalidFieldType() {
        FutureFieldTests.InvalidDto testDto = new FutureFieldTests.InvalidDto(LocalDate.now().toString());
        ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> validator.validate(testDto));
        Assertions.assertEquals("date: This annotation can only be used on [java.time.LocalDate]", exception.getMessage());
    }
}
