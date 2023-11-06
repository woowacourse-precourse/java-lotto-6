package lotto.util;

import static lotto.configuration.PatternConstants.THOUSAND_SEPARATOR;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.IntegerValidator;

public class StringUtil {

    public static String formatByThousandSeparator(int number) {
        DecimalFormat decimalFormat = new DecimalFormat(THOUSAND_SEPARATOR.getPattern());
        return decimalFormat.format(number);
    }

    public static String deleteAllSpaces(String input) {
        return input.replace(" ", "");
    }

    public static List<String> parseListseperatedByComma(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }
}
