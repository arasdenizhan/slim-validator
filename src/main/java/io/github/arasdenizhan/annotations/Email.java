package io.github.arasdenizhan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to validate whether a string represents a valid email address.
 * <p>
 * This annotation applies a standardized email regex pattern during validation.
 * <p>
 * For custom or stricter email formats, consider using the {@link Pattern} annotation instead.
 * * Example usage:
 *  * <pre>
 *  * {@code
 *  * public class UserDto {
 *  *     @Email
 *  *     private String email;
 *  * }
 *  * }
 *  * </pre>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "Field value must fit the email pattern!";
}
