package io.github.arasdenizhan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to validate an integer input to be less than the max value.
 * * Example usage:
 *  * <pre>
 *  * {@code
 *  * public class UserDto {
 *  *     @Max
 *  *     private String password;
 *  * }
 *  * }
 *  * </pre>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Max {
    int value() default 2147483647;
    String message() default "Field value must be less than or equal to 2147483647";
}
