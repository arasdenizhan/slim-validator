package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.NotNull;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.AbstractValidationStrategy;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class NotNullStrategy extends AbstractValidationStrategy {

    public NotNullStrategy() {
        super(Set.of(String.class.getTypeName()));
    }

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(NotNull.class)){
            checkUsageIsValid(field, errors);
            String message = field.getAnnotation(NotNull.class).message();
            if (value == null){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
