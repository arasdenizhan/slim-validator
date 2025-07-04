package io.github.arasdenizhan.annotations.constants;

public enum AnnotationName {
    EMAIL("Email"),
    LENGTH("Length"),
    MAX("Max"),
    MIN("Min"),
    NOT_NULL("NotNull"),
    PATTERN("Pattern");

    private final String value;

    AnnotationName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AnnotationName fromString(String value) {
        for (AnnotationName annotationName : AnnotationName.values()) {
            if (annotationName.getValue().equalsIgnoreCase(value)) {
                return annotationName;
            }
        }
        return null;
    }
}
