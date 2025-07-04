package io.github.arasdenizhan.core.strategy;

import io.github.arasdenizhan.core.exception.ValidationError;

import java.lang.reflect.Field;
import java.util.List;

public interface ValidationStrategy {
    void validate(Field field, Object value, List<ValidationError> errors);
}
