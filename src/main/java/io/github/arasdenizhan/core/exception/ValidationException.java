package io.github.arasdenizhan.core.exception;

import java.util.List;

public class ValidationException extends RuntimeException {

    public ValidationException(List<ValidationError> validationErrors) {
        super(validationErrors.stream().map(ValidationError::getErrorMessage).reduce((a, b) -> a + "\n" + b).orElse(""));
    }
}
