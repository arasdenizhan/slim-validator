package io.github.arasdenizhan.core.handler;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class FieldCacheHandler {
    private static final Map<Class<?>, Field[]> CLASS_FIELD_CACHE = new ConcurrentHashMap<>();

    public Field[] getFields(Class<?> clazz) {
        return CLASS_FIELD_CACHE.computeIfAbsent(clazz, Class::getDeclaredFields);
    }
}
