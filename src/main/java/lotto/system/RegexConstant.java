package lotto.system;

public enum RegexConstant {
    INPUT_PATTERN("[0-9]+"),
    TRAILING_ZEROS_FROM_DOUBLE("\\.?0*$"),
    LAST_DOT("\\.$"),
    DECIMAL_FORMAT("%,.2f");

    private final String regex;

    RegexConstant(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
