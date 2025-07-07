package io.github.arasdenizhan.core.exception;

/**
 * ValidationError is core error object designed for holding field and message for each validated field.
 */
public class ValidationError {
    private final String field;
    private final String message;

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    /**
     * Method for getting error message with field information and given message text.
     * @return String error message
     */
    public String getErrorMessage() {
        return field + ": " + message;
    }
}
