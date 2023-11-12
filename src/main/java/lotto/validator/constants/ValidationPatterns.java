package lotto.validator.constants;

public enum ValidationPatterns {
    WINNING_NUMBER_PATTERN("^[0-9,]+$");

    private final String pattern;

    ValidationPatterns(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
