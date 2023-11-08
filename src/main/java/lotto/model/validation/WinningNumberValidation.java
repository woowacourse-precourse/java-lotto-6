package lotto.model.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.Constants;
import lotto.utils.Util;
import lotto.view.ExceptionMessage;

public class WinningNumberValidation {

    public static List<Integer> validateWinningNumbers(String winningNumbersStr) {
        List<Integer> winningNumbers = Util.parseNumbers(winningNumbersStr);
        validateCount(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicates(winningNumbers);
        return winningNumbers;
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != Constants.WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < Constants.MIN_LOTTO_NUMBER || number > Constants.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE_ERROR.getMessage());
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }
}
