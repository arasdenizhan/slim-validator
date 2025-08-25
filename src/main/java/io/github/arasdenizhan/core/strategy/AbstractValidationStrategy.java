package io.github.arasdenizhan.core.strategy;

import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.exception.ValidationException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

/**
 * Core strategy abstract class for creating a validation strategy.
 * Given typeNames can be checked with default method to prevent usages with other fields.
 */
public abstract class AbstractValidationStrategy implements ValidationStrategy {
    private final Set<String> typeNames;

    public AbstractValidationStrategy(Set<String> typeNames) {
        this.typeNames = typeNames;
    }

    public abstract void validate(Field field, Object value, List<ValidationError> errors);

    public void checkUsageIsValid(Field field, List<ValidationError> errors) {
        if(!typeNames.contains(field.getType().getTypeName())){
            errors.add(new ValidationError(field.getName(), "This annotation can only be used on " + typeNames));
            throw new ValidationException(errors);
        }
    }
}
