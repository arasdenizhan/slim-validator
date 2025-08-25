package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Length;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.AbstractValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class LengthStrategy extends AbstractValidationStrategy {

    public LengthStrategy() {
        super(Set.of(String.class.getTypeName()));
    }

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Length.class)){
            checkUsageIsValid(field, errors);
            String message = field.getAnnotation(Length.class).message();
            if (value == null ||((String) value).length() < (field.getAnnotation(Length.class).min()) || ((String) value).length() > (field.getAnnotation(Length.class).max())){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
