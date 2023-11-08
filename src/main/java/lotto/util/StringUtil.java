package lotto.util;

import static lotto.configuration.PatternConstants.THOUSAND_SEPARATOR;

import java.text.DecimalFormat;

public class StringUtil {

    public static String formatByThousandSeparator(int number) {
        DecimalFormat decimalFormat = new DecimalFormat(THOUSAND_SEPARATOR.getPattern());
        return decimalFormat.format(number);
    }

    public static String deleteAllSpaces(String input) {
        return input.replace(" ", "");
    }
}
