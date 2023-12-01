package lotto.view;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public enum Regex {
    NUMBER("^[0-9]*$"),
    CASH("###,###"),
    CASH_ROUND("#,##0.0"), // .0 -> 소수점 한자리 까지 포함, .00 -> 소수점 두자리 까지 포함 ...
    ROUND("0.0"),
    COMMA(","),

    ;

    private final String regex;
    private final Pattern pattern;

    Regex(final String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }


    /**
     * 반올림을 포함한 숫자 포맷
     * 324329209.35823 => 324,329,209.4
     */
    public static String formatCashPrizeWithRounds(float cash) {
        return new DecimalFormat(Regex.CASH_ROUND.regex).format(cash);
    }

    public static String formatRounds(float number) {
        return new DecimalFormat(Regex.ROUND.regex).format(number);
    }

    // 12345 => 12,345
    public static String formatCashPrize(int cash) {
        return new DecimalFormat(Regex.CASH.regex).format(cash);
    }

    public boolean matches(final String value) {
        return pattern.matcher(value)
                .matches();
    }

    public String getRegex() {
        return regex;
    }
}
