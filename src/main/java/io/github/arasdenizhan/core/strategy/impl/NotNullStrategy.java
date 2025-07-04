package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.NotNull;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;

public class NotNullStrategy implements ValidationStrategy {

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(NotNull.class)){
            String message = field.getAnnotation(NotNull.class).message();
            if (value == null){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
