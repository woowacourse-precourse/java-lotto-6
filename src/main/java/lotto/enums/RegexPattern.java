package lotto.enums;

import java.util.regex.Pattern;

public enum RegexPattern {
    NOT_NUMBER(Pattern.compile(".*[\\D].*"));

    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
