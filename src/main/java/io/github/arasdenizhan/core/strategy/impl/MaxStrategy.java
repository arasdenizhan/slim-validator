package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Max;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;

public class MaxStrategy implements ValidationStrategy {

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Max.class)){
            String message = field.getAnnotation(Max.class).message();
            if ((int) value > field.getAnnotation(Max.class).value()){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
