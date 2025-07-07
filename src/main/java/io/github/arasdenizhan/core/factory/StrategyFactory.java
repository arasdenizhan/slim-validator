package io.github.arasdenizhan.core.factory;

import io.github.arasdenizhan.core.strategy.ValidationStrategy;
import io.github.arasdenizhan.core.strategy.impl.*;
import io.github.arasdenizhan.annotations.constants.AnnotationName;

import java.util.EnumMap;
import java.util.Map;

import static io.github.arasdenizhan.annotations.constants.AnnotationName.*;

/**
 * Factory class responsible for providing appropriate {@link ValidationStrategy} instances
 * based on the given annotation type.
 * <p>
 * Used internally by the validator to resolve strategy objects for specific annotations.
 */
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

    /**
     * Returns the {@link ValidationStrategy} associated with the given annotation name.
     *
     * @param annotationName the annotation name to resolve the strategy for
     * @return the corresponding validation strategy, or {@code null} if not supported
     */
    public ValidationStrategy create(AnnotationName annotationName) {
        return STRATEGIES.get(annotationName);
    }

    /**
     * Checks whether a validation strategy is available for the given annotation.
     *
     * @param name the annotation name to check
     * @return {@code true} if a strategy is registered for the annotation, {@code false} otherwise
     */
    public boolean supports(AnnotationName name) {
        return STRATEGIES.containsKey(name);
    }
}
