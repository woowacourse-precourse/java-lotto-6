package lotto.common;

import java.util.Arrays;
import java.util.List;
import lotto.exception.money.InvalidNumberFormatException;

public class CommonUtil {

    public static final String SPLIT_REGEX = ",";

    public static long convertToLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(input);
        }
    }

    public static List<Integer> convertToNumbers(String input) {
        return Arrays.stream(input.split(SPLIT_REGEX))
                .map(String::trim)
                .map(CommonUtil::convertToNumber)
                .toList();
    }

    public static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(input);
        }
    }
}
