package lotto.validation;

import java.util.List;

public class BonusNumberValidator {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;

    public static void validate(List<Integer> numbers, int bonusNumber) {
        validateBonusNumberOutRange(bonusNumber);
        validateBonusNumberDuplication(numbers, bonusNumber);
    }

    private static void validateBonusNumberOutRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(LottoException.OUT_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < RANGE_START || RANGE_END < number;
    }

    private static void validateBonusNumberDuplication(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoException.BONUS_DUPLICATION_ERROR_MESSAGE.getMessage());
        }
    }
}
