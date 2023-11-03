package lotto.constants;

import java.util.regex.Pattern;

public enum InputPattern {
    NUMERIC_PATTERN(Pattern.compile("^\\d*$"));

    private final Pattern pattern;

    InputPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public static boolean isNotNumeric(String attemptNumber) {
        Pattern pattern = NUMERIC_PATTERN.pattern;
        return !pattern.matcher(attemptNumber).matches();
    }

}
