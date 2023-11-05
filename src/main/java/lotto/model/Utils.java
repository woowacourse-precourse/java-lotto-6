package lotto.model;

import java.util.Arrays;
import java.util.List;

public final class Utils {

    private static final String INVALID_PURCHASE_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.";
    private static final String WINNING_NUMBER_SEPARATOR = ",";

    private Utils() {
    }

    public static int convertStringToInt(final String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_EXCEPTION_MESSAGE);
        }
    }

    public static List<Integer> convertStringToIntegerList(final String string) {
        return splitWinningNumbers(string).stream()
                .map(inputNumber -> convertStringToInt(inputNumber))
                .toList();
    }

    private static List<String> splitWinningNumbers(final String winningNumbers) {
        return Arrays.stream(winningNumbers.split(WINNING_NUMBER_SEPARATOR))
                .toList();
    }
}
