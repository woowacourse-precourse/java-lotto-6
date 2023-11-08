package lotto.global.enums;

public enum Regex {
    ONLY_NUMBERS("\\d+"); // \d는 숫자를 나타내고, +는 하나 이상의 숫자가 연속됨을 의미합니다.

    private final String pattern;

    Regex(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public boolean matches(String input) {
        return input.matches(pattern);
    }
}
