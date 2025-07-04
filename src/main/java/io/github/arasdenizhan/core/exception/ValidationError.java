package io.github.arasdenizhan.core.exception;

public class ValidationError {
    private final String field;
    private final String message;

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getErrorMessage() {
        return field + ": " + message;
    }
}
