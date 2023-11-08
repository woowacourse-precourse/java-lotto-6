package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoError;
import lotto.exception.LottoValidationException;

public class WinningNumbersValidator {

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validate(List<Integer> numbers, int bonusNumber) {
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
        validateRange(numbers);
        validateBonusNumber(bonusNumber, numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            throw new LottoValidationException(LottoError.INVALID_WINNING_NUMBER_COUNT.toString());
        }
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new LottoValidationException(LottoError.DUPLICATE_WINNING_NUMBER.toString());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new LottoValidationException(LottoError.NUMBER_OUT_OF_RANGE.toString());
        }
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoValidationException(
                    LottoError.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER.toString());
        }
    }
}
