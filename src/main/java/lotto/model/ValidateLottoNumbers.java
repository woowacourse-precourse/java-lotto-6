package lotto.model;

import lotto.exception.CustomIllegalArgumentException;
import lotto.exception.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ValidateLottoNumbers {
    private final static int NUMBERS_SIZE = 6;
    private final static int WINNING_NUMBERS_SIZE = 7;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    protected void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers, ExceptionMessage.INVALID_LOTTO_SIZE);
        validateRange(numbers, ExceptionMessage.INVALID_NUMBER_RANGE);
        validateDuplicationNumbers(numbers);
    }

    protected void validateWinningLottoNumbers(List<Integer> numbers, int bonusNumber) {
        validateSize(numbers, ExceptionMessage.INVALID_WINNING_NUMBERS_SIZE);
        validateRange(numbers, ExceptionMessage.INVALID_WINNING_NUMBERS_RANGE);
        validateDuplicationNumbers(numbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateSize(List<Integer> numbers, ExceptionMessage exceptionMessage) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new CustomIllegalArgumentException(exceptionMessage);
        }
    }

    private void validateRange(List<Integer> numbers, ExceptionMessage exceptionMessage) {
        for (int number : numbers) {
            if (validateNumberRange(number)) {
                throw new CustomIllegalArgumentException(exceptionMessage);
            }
        }
    }

    private void validateDuplicationNumbers(List<Integer> numbers) {
        Set<Integer> notDuplicationNumbers = new HashSet<>(numbers);

        if (notDuplicationNumbers.size() != NUMBERS_SIZE) {
            throw new CustomIllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateDuplicationNumbers(List<Integer> numbers, int bonusNumber) {
        Set<Integer> notDuplicationNumbers = new HashSet<>(numbers);
        notDuplicationNumbers.add(bonusNumber);

        if (notDuplicationNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new CustomIllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBER);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (validateNumberRange(bonusNumber)) {
            throw new CustomIllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER_RANGE);
        }
    }

    private boolean validateNumberRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }
}