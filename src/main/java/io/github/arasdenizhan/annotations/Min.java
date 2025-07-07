package io.github.arasdenizhan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to validate an integer input to be greeter than the min value.
 * * Example usage:
 *  * <pre>
 *  * {@code
 *  * public class UserDto {
 *  *     @Min
 *  *     private String password;
 *  * }
 *  * }
 *  * </pre>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Min {
    int value() default 0;
    String message() default "Field value must be greater than or equal to 0";
}
