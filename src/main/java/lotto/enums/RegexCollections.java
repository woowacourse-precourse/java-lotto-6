package lotto.enums;

public enum RegexCollections {
    REGEX_FOR_INPUT_LOTTO_PAYMENT("^[0-9]+$"),
    REGEX_FOR_LOTTO_NUMBER_RANGE("^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^[4]{1}[0-5]{1}$");

    String regex;

    RegexCollections(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
