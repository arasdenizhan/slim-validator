package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Min;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.AbstractValidationStrategy;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MinStrategy extends AbstractValidationStrategy {

    public MinStrategy() {
        super(new LinkedHashSet<>(Set.of(int.class.getTypeName(), Integer.class.getTypeName())));
    }

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Min.class)){
            checkUsageIsValid(field, errors);
            String message = field.getAnnotation(Min.class).message();
            if ((int) value < field.getAnnotation(Min.class).value()){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
