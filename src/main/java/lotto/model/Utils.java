package lotto.model;

import java.util.Arrays;
import java.util.List;

public final class Utils {

    private static final String INVALID_PURCHASE_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.";
    private static final String WINNING_NUMBER_SEPARATOR = ",";

    private Utils() {
    }

    public static int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_EXCEPTION_MESSAGE);
        }
    }

    public static List<Integer> convertStringToIntegerList(String string) {
        return splitWinningNumbers(string).stream()
                .map(inputNumber -> convertStringToInt(inputNumber))
                .toList();
    }

    private static List<String> splitWinningNumbers(String string) {
        return Arrays.stream(string.split(WINNING_NUMBER_SEPARATOR))
                .toList();
    }
}
