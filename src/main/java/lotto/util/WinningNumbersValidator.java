package lotto.util;

import java.util.List;

public class WinningNumbersValidator {
    public static void validateWinningNumbers(List<String> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IN_EMPTY.getMessage());
        }
    }
}
