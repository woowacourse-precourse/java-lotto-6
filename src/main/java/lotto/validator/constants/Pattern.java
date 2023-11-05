package lotto.validator.constants;

public enum Pattern {
    NUMERIC("[0-9]+"),
    DIVIDE_ONE_THOUSAND("[0-9]*000");

    private final String pattern;

    private Pattern(String pattern) {
        this.pattern = pattern;
    }

    public String pattern() {
        return pattern;
    }
}
