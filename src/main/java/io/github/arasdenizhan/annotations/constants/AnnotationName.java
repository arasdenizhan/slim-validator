package io.github.arasdenizhan.annotations.constants;

import io.github.arasdenizhan.core.strategy.ValidationStrategy;
import io.github.arasdenizhan.core.strategy.impl.*;

public enum AnnotationName {
    EMAIL("Email", new EmailStrategy()),
    LENGTH("Length", new LengthStrategy()),
    MAX("Max", new MaxStrategy()),
    MIN("Min", new MinStrategy()),
    NOT_NULL("NotNull", new NotNullStrategy()),
    PATTERN("Pattern", new PatternStrategy()),
    NOT_BLANK("NotBlank", new NotBlankStrategy()),
    FUTURE("Future", new FutureStrategy()),
    PAST("Past", new PastStrategy());

    private final String value;
    private final ValidationStrategy strategy;

    AnnotationName(String value, ValidationStrategy strategy) {
        this.value = value;
        this.strategy = strategy;
    }

    public String getValue() {
        return value;
    }

    public ValidationStrategy getStrategy() {
        return strategy;
    }

    public static AnnotationName fromString(String value) {
        for (AnnotationName annotationName : AnnotationName.values()) {
            if (annotationName.getValue().equalsIgnoreCase(value)) {
                return annotationName;
            }
        }
        return null;
    }
}
