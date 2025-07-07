package io.github.arasdenizhan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to validate a string for given regEx pattern.
 * By default, it doesn't have any value. Because of this a value <p>must</p> be supplied for usage.
 * * Example usage:
 *  * <pre>
 *  * {@code
 *  * public class UserDto {
 *  *     @Pattern("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
 *  *     private String email;
 *  * }
 *  * }
 *  * </pre>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pattern {
    String value();
    String message() default "Field must follow the pattern!";
}
