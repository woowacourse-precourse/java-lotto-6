package lotto.configuration;

public enum PatternConstants {
    THOUSAND_SEPARATOR("###,##0"),
    THOUSAND_SEPARATOR_WITH_ROUNDED_UNTIL_FIRST_DECIMAL(THOUSAND_SEPARATOR.pattern+".0");

    private String pattern;

    PatternConstants(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
