package lotto.utils;

import static lotto.utils.Constants.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import lotto.view.ExceptionMessage;

public class Util {

    public static List<Integer> parseNumbers(String winningNumber) {
        validateFormat(winningNumber);
        return Arrays.stream(winningNumber.split(DELIMITER))
                .map(String::trim)
                .map(Util::convertToInt)
                .collect(Collectors.toList());
    }

    private static void validateFormat(String winningNumbersStr) {
        Matcher matcher = Constants.WINNING_NUMBER_PATTERN.matcher(winningNumbersStr);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FORMAT_ERROR.getMessage());
        }
    }

    public static int convertToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
        }
    }
}
