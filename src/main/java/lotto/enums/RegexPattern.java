package lotto.enums;

public enum RegexPattern {
    AMOUNT_CHECK("^[1-9][0-9]*(000)$"),
    LOTTO_NUMBERS_CHECK("^(0*[1-9]|[1-3][0-9]|4[0-5])(,(0*[1-9]|[1-3][0-9]|4[0-5])){5}$"),
    LOTTO_BONUS_NUMBER_CHECK("^(0|[1-9]|[1-3][0-9]|4[0-5])$");

    private final String pattern;

    RegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
