package lotto.util;

import static lotto.configuration.PatternConstants.THOUSAND_SEPARATOR_WITH_ROUNDED_UNTIL_FIRST_DECIMAL;
import static lotto.configuration.PatternConstants.THOUSAND_SEPARATOR_WITH_ROUNDED_UNTIL_FIRST_DECIMAL_WITH_PERCENT;

import java.text.DecimalFormat;

public class DoubleUtil {

    public static String formatByThousandSeparatorAndRoundUntilFirstDecimal(double number) {
        DecimalFormat decimalFormat = new DecimalFormat(
                THOUSAND_SEPARATOR_WITH_ROUNDED_UNTIL_FIRST_DECIMAL.getPattern());
        return decimalFormat.format(number);
    }

    public static String formatByThousandSeparatorAndRoundUntilFirstDecimalWithPercent(double number) {
        DecimalFormat decimalFormat = new DecimalFormat(
                THOUSAND_SEPARATOR_WITH_ROUNDED_UNTIL_FIRST_DECIMAL_WITH_PERCENT.getPattern());
        return decimalFormat.format(number);
    }

}
