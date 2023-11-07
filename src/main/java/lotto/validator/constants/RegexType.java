package lotto.validator.constants;

public enum RegexType {
    REMOVE_WHITE_SPACE_REGEX("\\s+"),
    SPLIT_DELIMITER(",");
    private final String regex;

    RegexType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
