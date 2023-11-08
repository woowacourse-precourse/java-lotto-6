package lotto.enums;

public enum RegularExpression {
    POSITIVE_INTEGER("^[1-9]\\d*$"),
    NUMBERS_AND_COMMA("^[0-9,]+$");

    private final String regex;

    RegularExpression(String regex) {
        this.regex = regex;
    }

    public String type() {
        return regex;
    }
}
