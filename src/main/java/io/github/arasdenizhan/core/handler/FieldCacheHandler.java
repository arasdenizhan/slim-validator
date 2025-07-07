package io.github.arasdenizhan.core.handler;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility class to efficiently store given class fields in a cache.
 * <p>
 * Instead of each time calling {@code getDeclaredFields()} on a class,
 * this class first checks if the cache map has already fields for this class.
 * If not, it gets all declared fields and put them to the cache.
 * This avoids performance exhaustion while getting declared fields for a class.
 * <p>
 */
public final class FieldCacheHandler {
    private static final Map<Class<?>, Field[]> CLASS_FIELD_CACHE = new ConcurrentHashMap<>();

    public Field[] getFields(Class<?> clazz) {
        return CLASS_FIELD_CACHE.computeIfAbsent(clazz, Class::getDeclaredFields);
    }
}
