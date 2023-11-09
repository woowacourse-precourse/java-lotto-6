package lotto.view.input;

public enum InputRegex {
    NUMBER_REGEX("^[0-9]+$"),
    DELIMITER_REGEX(",");

    private final String regex;

    InputRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
