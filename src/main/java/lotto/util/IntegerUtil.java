package lotto.util;

import static lotto.configuration.PatternConstants.THOUSAND_SEPARATOR;

import java.text.DecimalFormat;

public class IntegerUtil {

    public static String formatByThousandSeparator(int number) {
        DecimalFormat decimalFormat = new DecimalFormat(THOUSAND_SEPARATOR.getPattern());
        return decimalFormat.format(number);
    }

    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
