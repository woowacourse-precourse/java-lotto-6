package lotto.utils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public final class LottoUtils {
    private static final String DELIMITER = ",";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private LottoUtils() {
    }

    public static List<Integer> toIntegerList(String input) {
        try {
            return Arrays.stream(split(input))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.getMessage());
        }
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
    public static void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public static String format(String pattern, int number) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }
}
