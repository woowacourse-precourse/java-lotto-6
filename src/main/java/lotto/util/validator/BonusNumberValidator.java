package lotto.util.validator;

import lotto.util.exception.ErrorCode;

import java.util.List;

public class BonusNumberValidator {
    public static final int MIN_RANDOM_BOUND = 1;
    public static final int MAX_RANDOM_BOUND = 45;

    public int validateBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        validateNullorEmpty(inputBonusNumber);

        int number = validateNumberType(inputBonusNumber);
        validateNumberRange(number);

        validateNumberDuplication(number, winningNumbers);
        return number;
    }

    private void validateNullorEmpty(String inputBonusNumber) {
        if (inputBonusNumber == null || inputBonusNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NULL_OR_EMPTY_BONUS_NUMBER.getMessage());
        }
    }

    private int validateNumberType(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER_TYPE.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_RANDOM_BOUND || number > MAX_RANDOM_BOUND) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateNumberDuplication(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}