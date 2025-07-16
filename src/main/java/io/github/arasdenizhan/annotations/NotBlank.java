package io.github.arasdenizhan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to validate a string to be not null and contain at least 1 char.
 * For custom or stricter string controls, consider using the {@link Pattern} annotation instead.
 * * Example usage:
 *  * <pre>
 *  * {@code
 *  * public class UserDto {
 *  *     @NotBlank
 *  *     private String password;
 *  * }
 *  * }
 *  * </pre>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
    String message() default "Field must not be null or contain at least 1 character";
}
