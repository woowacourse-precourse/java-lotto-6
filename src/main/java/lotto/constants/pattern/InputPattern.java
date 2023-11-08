package lotto.constants.pattern;

import java.util.regex.Pattern;

public enum InputPattern {
    NUMERIC_PATTERN(Pattern.compile("^\\d*$")),
    DIVISION_COMMA_PATTERN(Pattern.compile("^\\d+[,\\d+]*$"));

    private final Pattern pattern;

    InputPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public static boolean isNotNumeric(String purchasePrice) {
        Pattern pattern = NUMERIC_PATTERN.pattern;
        return !pattern.matcher(purchasePrice).matches();
    }

    public static boolean isNotDivisionComma(String lotto) {
        Pattern pattern = DIVISION_COMMA_PATTERN.pattern;
        return !pattern.matcher(lotto).matches();
    }

}
