package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Max;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.AbstractValidationStrategy;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MaxStrategy extends AbstractValidationStrategy {

    public MaxStrategy() {
        super(new LinkedHashSet<>(Set.of(int.class.getTypeName(), Integer.class.getTypeName())));
    }

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Max.class)){
            checkUsageIsValid(field, errors);
            String message = field.getAnnotation(Max.class).message();
            if ((int) value > field.getAnnotation(Max.class).value()){
                errors.add(new ValidationError(field.getName(), message));
            }
        }
    }
}
