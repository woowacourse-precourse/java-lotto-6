package lotto.util;

import java.util.List;

import static lotto.util.LottoInformation.NUMBER_OF_NUMBERS

public class WinningNumbersValidator {
    public static void validateWinningNumbers(List<String> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IN_EMPTY.getMessage());
        }

        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IS_NOT_SIX.getMessage());
        }
    }

    private static boolean isSixNumbers(List<String> numbers) {
        return numbers.size() == NUMBER_OF_NUMBERS;
    }
}
