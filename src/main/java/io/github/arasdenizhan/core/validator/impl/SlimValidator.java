package io.github.arasdenizhan.core.validator.impl;

import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.exception.ValidationException;
import io.github.arasdenizhan.core.factory.StrategyFactory;
import io.github.arasdenizhan.core.handler.AccessibleFieldHandler;
import io.github.arasdenizhan.core.handler.FieldCacheHandler;
import io.github.arasdenizhan.core.validator.Validator;
import io.github.arasdenizhan.annotations.constants.AnnotationName;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SlimValidator implements Validator {
    private static final Logger LOGGER = Logger.getLogger(SlimValidator.class.getName());
    private static final StrategyFactory FACTORY = new StrategyFactory();
    private static final FieldCacheHandler FIELD_CACHE = new FieldCacheHandler();

    @Override
    public void validate(Object object) {
        List<ValidationError> errors = new ArrayList<>();
        Class<?> objectClass = object.getClass();
        Arrays.stream(FIELD_CACHE.getFields(objectClass)).forEach(field -> {
            try {
                Object value = AccessibleFieldHandler.getFieldValue(field, object);
                for (Annotation annotation : field.getDeclaredAnnotations()) {
                    String name = annotation.annotationType().getSimpleName();
                    AnnotationName enumName = AnnotationName.fromString(name);
                    if (enumName == null || !FACTORY.supports(enumName)) continue;
                    FACTORY.create(enumName).validate(field, value, errors);
                }
            } catch (IllegalAccessException e) {
                LOGGER.log(Level.SEVERE, "Validator api failed: " +e.getMessage(), e);
            }
        });
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
