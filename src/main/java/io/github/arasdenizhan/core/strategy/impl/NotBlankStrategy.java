package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.NotBlank;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.AbstractValidationStrategy;
import io.github.arasdenizhan.core.strategy.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class NotBlankStrategy extends AbstractValidationStrategy {
    private static final String NON_SPACE_REGEX = ".*\\S.*";

    public NotBlankStrategy() {
        super(Set.of(String.class.getTypeName()));
    }

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(NotBlank.class)){
            checkUsageIsValid(field, errors);
            String message = field.getAnnotation(NotBlank.class).message();
            if (value == null || ((String) value).isEmpty() || !((String) value).matches(NON_SPACE_REGEX)){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
