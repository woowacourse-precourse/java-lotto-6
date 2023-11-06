package lotto.config;

public enum InputPattern {
    PURCHASE_AMOUNT_REGEX("^[0-9]+$"),
    WINNING_LOTTO_NUMERIC_REGEX("^(?:45|[1-9]|[1-3][0-9]|4[0-4])(?:,(?:45|[1-9]|[1-3][0-9]|4[0-4]))*$"),
    WINNING_LOTTO_COMMA_REGEX("^[^,]+(,[^,]+)*$");

    private final String regex;

    InputPattern(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
