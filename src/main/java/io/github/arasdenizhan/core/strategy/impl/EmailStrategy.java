package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Email;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;

public class EmailStrategy implements ValidationStrategy {

    private static final String EMAIL_PATTERN = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Email.class)){
            String message = field.getAnnotation(Email.class).message();
            if (value == null || !((String) value).matches(EMAIL_PATTERN)){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
