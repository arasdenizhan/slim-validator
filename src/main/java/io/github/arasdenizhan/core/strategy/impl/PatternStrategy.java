package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Pattern;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.ValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;

public class PatternStrategy implements ValidationStrategy {

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Pattern.class)){
            String message = field.getAnnotation(Pattern.class).message();
            if (value == null || !((String) value).matches(field.getAnnotation(Pattern.class).value())){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
