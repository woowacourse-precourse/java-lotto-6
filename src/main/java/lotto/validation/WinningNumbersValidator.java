package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.LottoError;
import lotto.exception.LottoValidationException;

public class WinningNumbersValidator {

    public static void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
        validateRange(numbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoValidationException(LottoError.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER.toString());
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoValidationException(LottoError.INVALID_WINNING_NUMBER_COUNT.toString());
        }
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new LottoValidationException(LottoError.DUPLICATE_WINNING_NUMBER.toString());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new LottoValidationException(LottoError.NUMBER_OUT_OF_RANGE.toString());
        }
    }
}
