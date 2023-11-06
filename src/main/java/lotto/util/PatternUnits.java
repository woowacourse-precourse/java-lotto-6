package lotto.util;

public enum PatternUnits {
    PATTERN_FOR_FINDING_SPECIAL_SIGN("[ !@#$%^&*().?\":{}|<>]"),
    PATTERN_FOR_DECIMAL_FORMAT("###,###");

    private final String pattern;

    PatternUnits(final String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
