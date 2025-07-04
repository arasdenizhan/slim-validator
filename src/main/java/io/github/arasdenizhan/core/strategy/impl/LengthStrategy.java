package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Length;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;

public class LengthStrategy implements ValidationStrategy {

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Length.class)){
            String message = field.getAnnotation(Length.class).message();
            if (value == null ||((String) value).length() < (field.getAnnotation(Length.class).min()) || ((String) value).length() > (field.getAnnotation(Length.class).max())){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
