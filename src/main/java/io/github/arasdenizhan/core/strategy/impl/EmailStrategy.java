package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Email;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.AbstractValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class EmailStrategy extends AbstractValidationStrategy {

    private static final String EMAIL_PATTERN = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public EmailStrategy() {
        super(Set.of(String.class.getTypeName()));
    }

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Email.class)){
            checkUsageIsValid(field, errors);
            String message = field.getAnnotation(Email.class).message();
            if (value == null || !((String) value).matches(EMAIL_PATTERN)){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
