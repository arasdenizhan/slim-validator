package io.github.arasdenizhan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to validate the length of a string with specified minimum and maximum values.
 * For custom or stricter length controls, consider using the {@link Pattern} annotation instead.
 * * Example usage:
 *  * <pre>
 *  * {@code
 *  * public class UserDto {
 *  *     @Length(min=8, max=16)
 *  *     private String password;
 *  * }
 *  * }
 *  * </pre>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    int min() default 0;
    int max() default 2147483647;
    String message() default "Field value must fit the length!";
}
