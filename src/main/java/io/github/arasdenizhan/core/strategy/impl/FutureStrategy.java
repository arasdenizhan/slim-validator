package io.github.arasdenizhan.core.strategy.impl;

import io.github.arasdenizhan.annotations.Future;
import io.github.arasdenizhan.core.exception.ValidationError;
import io.github.arasdenizhan.core.strategy.AbstractValidationStrategy;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Set;

public class FutureStrategy extends AbstractValidationStrategy {

    public FutureStrategy() {
        super(Set.of(LocalDate.class.getTypeName()));
    }

    @Override
    public void validate(Field field, Object value, List<ValidationError> errors) {
        if (field.isAnnotationPresent(Future.class)){
            checkUsageIsValid(field, errors);
            String message = field.getAnnotation(Future.class).message();
            String dateString = field.getAnnotation(Future.class).value();
            try{
                LocalDate parsedDate = LocalDate.parse(dateString);
                if(value == null){
                    errors.add(new ValidationError(field.getName(), "Field value is null!"));
                    return;
                }
                LocalDate fieldValue = (LocalDate) value;
                if (fieldValue.isBefore(parsedDate)){
                    errors.add(new ValidationError(field.getName(), message + dateString));
                }
            } catch (DateTimeParseException e){
                errors.add(new ValidationError(field.getName(), "Date format supplied to annotation is wrong!"));
            }
        }
    }
}
