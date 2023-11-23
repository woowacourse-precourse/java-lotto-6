package lotto.utils;

import java.util.List;

public enum Delimiter {

    COMMA(","),
    SPACE(" "),
    BAR("-"),
    FORMAT("[%s]");

    private final String unit;

    Delimiter(final String unit) {
        this.unit = unit;
    }

    public static String[] splitWithComma(final String target) {
        return target.split(COMMA.unit);
    }

    public static String joinWithComma(final List<String> target) {
        return String.join(COMMA.unit + SPACE.unit, target);
    }

    public static String FormatWithTarget(final String target) {
        return String.format(FORMAT.unit, target);
    }


    public static String repeatUnderBar(final int count) {
        return BAR.unit.repeat(count);
    }
}
