package lotto.constant;

import java.util.regex.Pattern;

public enum StringPattern {
    NUMBER_PATTERN(Pattern.compile("^[0-9]*$"));

    private final Pattern pattern;

    StringPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
    public boolean isNotMatching(String input) {
        return !this.pattern.matcher(input).matches();
    }
}
