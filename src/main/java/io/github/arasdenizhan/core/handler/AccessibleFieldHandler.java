package io.github.arasdenizhan.core.handler;

import java.lang.reflect.Field;

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
