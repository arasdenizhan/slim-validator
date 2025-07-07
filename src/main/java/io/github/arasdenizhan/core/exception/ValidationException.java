package io.github.arasdenizhan.core.exception;

import java.util.List;

/**
 * Exception thrown by the validator when one or more fields fail validation.
 * <p>
 * Aggregates the error messages of all failed fields into a single exception message.
 */
public class ValidationException extends RuntimeException {
    /**
     * @param validationErrors List of error objects for the library. Each one will be used to create an exception message.
     */
    public ValidationException(List<ValidationError> validationErrors) {
        super(validationErrors.stream().map(ValidationError::getErrorMessage).reduce((a, b) -> a + "\n" + b).orElse(""));
    }
}
