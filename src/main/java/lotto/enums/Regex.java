package lotto.enums;

public enum Regex {
    NON_DIGIT_REGEX("\\D+"),
    INPUT_WINNING_NUMBERS_REGEX("^\\d+(,\\d+){5}$");
    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
