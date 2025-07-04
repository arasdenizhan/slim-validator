package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Min;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;

public class MinStrategy implements ValidationStrategy {

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Min.class)){
            String message = field.getAnnotation(Min.class).message();
            if ((int) value <= field.getAnnotation(Min.class).value()){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
