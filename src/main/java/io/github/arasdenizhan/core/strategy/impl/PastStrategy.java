package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Past;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.AbstractValidationStrategy;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

public class PastStrategy extends AbstractValidationStrategy {

    public PastStrategy() {
        super(Set.of(LocalDate.class.getTypeName()));
    }

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Past.class)){
            checkUsageIsValid(field, errors);
            String message = field.getAnnotation(Past.class).message();
            String dateString = field.getAnnotation(Past.class).value();
            try{
                LocalDate parsedDate = LocalDate.parse(dateString);
                if(value == null){
                    errors.add(new ValidationError(field.getName(), "Field value is null!"));
                    return;
                }
                LocalDate fieldValue = (LocalDate) value;
                if (fieldValue.isAfter(parsedDate)){
                    errors.add(new ValidationError(field.getName(), message + dateString));
                }
            } catch (DateTimeParseException e){
                errors.add(new ValidationError(field.getName(), "Date format supplied to annotation is wrong!"));
            }
        }
    }
}
