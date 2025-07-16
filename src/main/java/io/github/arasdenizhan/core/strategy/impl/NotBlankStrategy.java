package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.NotBlank;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;

public class NotBlankStrategy implements ValidationStrategy {

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(NotBlank.class)){
            String message = field.getAnnotation(NotBlank.class).message();
            if (value == null || ((String) value).isEmpty()){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
