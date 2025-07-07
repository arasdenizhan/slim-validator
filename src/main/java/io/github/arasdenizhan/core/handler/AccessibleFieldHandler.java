package io.github.arasdenizhan.core.handler;

import java.lang.reflect.Field;

/**
 * Utility class to efficiently retrieve the value of a field via reflection.
 * <p>
 * Instead of blindly calling {@code setAccessible(true)} on each access,
 * this class first checks if the field is already accessible using {@code canAccess()}.
 * If not accessible, it enables access explicitly. This avoids unnecessary reflection overhead.
 * <p>
 * Note: In some JVM implementations, repeated {@code setAccessible(true)} calls are cached,
 * which can improve performance slightly, though this behavior is not guaranteed in all Java versions.
 */
public final class AccessibleFieldHandler {
    private AccessibleFieldHandler() {}

    /**
     * Securely retrieves the value of a field using reflection,
     * enabling access only if necessary.
     *
     * @param field  The field to read from
     * @param target The object instance
     * @return The value of the field
     * @throws IllegalAccessException if the field is not accessible and cannot be made accessible
     */
    public static Object getFieldValue(Field field, Object target) throws IllegalAccessException {
        boolean accessibleBefore = field.canAccess(target);
        if (!accessibleBefore) {
            field.setAccessible(true);
        }
        return field.get(target);
    }
}
