package lotto.utils;

import static lotto.enums.ExceptionMessageType.DUPLICATE_BONUS_NUMBER;
import static lotto.enums.ExceptionMessageType.DUPLICATE_WINNING_NUMBERS;
import static lotto.enums.ExceptionMessageType.INVALID_SEPARATOR_OR_NUMBER_COUNT;
import static lotto.enums.ExceptionMessageType.NUMBER_OUT_OF_RANGE;

import java.util.List;
import java.util.regex.Pattern;

public class LottoNumbersValidator extends GeneralValidator {
    private static int MIN_NUM = 1;
    private static int MAX_NUM = 45;

    public static void validateSeparator(String winningNumbers) {
        String REGEX = "^\\d,\\d,\\d,\\d,\\d,\\d$";
        if (!Pattern.matches(REGEX, winningNumbers)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_OR_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateRange(int number) {
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        if (
                numbers.size() != numbers.stream()
                                        .distinct()
                                        .count()
        ) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    public static void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (
                winningNumbers.stream()
                        .anyMatch(winningNum -> winningNum == bonusNumber)
        ) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
