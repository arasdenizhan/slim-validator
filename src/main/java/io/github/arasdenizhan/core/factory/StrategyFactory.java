package io.github.arasdenizhan.core.factory;

import io.github.arasdenizhan.core.strategy.ValidationStrategy;
import io.github.arasdenizhan.core.strategy.impl.*;
import io.github.arasdenizhan.annotations.constants.AnnotationName;

import java.util.EnumMap;
import java.util.Map;

import static io.github.arasdenizhan.annotations.constants.AnnotationName.*;

public final class StrategyFactory {
    private static final Map<AnnotationName, ValidationStrategy> STRATEGIES = new EnumMap<>(
            Map.of(
                    MAX, new MaxStrategy(),
                    MIN, new MinStrategy(),
                    NOT_NULL, new NotNullStrategy(),
                    LENGTH, new LengthStrategy(),
                    EMAIL, new EmailStrategy(),
                    PATTERN, new PatternStrategy()
            )
    );

    public ValidationStrategy create(AnnotationName annotationName) {
        return STRATEGIES.get(annotationName);
    }

    public boolean supports(AnnotationName name) {
        return STRATEGIES.containsKey(name);
    }
}
