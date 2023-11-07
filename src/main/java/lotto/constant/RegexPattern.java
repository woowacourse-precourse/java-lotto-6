package lotto.constant;

import java.util.regex.Pattern;

public enum RegexPattern {
    LOTTO_REGEX_PATTERN(Pattern.compile("^(?:[1-9]|[1-3][0-9]|4[0-5])$")),
    NUMERIC_PATTERN(Pattern.compile("\\d+"));

    private final Pattern pattern;

    RegexPattern(final Pattern pattern) {
        this.pattern = pattern;
    }

    public static boolean isNumberic(String input) {
        Pattern pattern = NUMERIC_PATTERN.pattern;
        return !pattern.matcher(input).matches();
    }

    public static boolean isLottoNumberAvailable(Integer input) {
        Pattern pattern = LOTTO_REGEX_PATTERN.pattern;
        return !pattern.matcher(input.toString()).matches();
    }
}
