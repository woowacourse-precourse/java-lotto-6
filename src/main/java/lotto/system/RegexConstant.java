package lotto.system;

public enum RegexConstant {
    INPUT_PATTERN("[0-9]+");

    private final String regex;

    RegexConstant(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
