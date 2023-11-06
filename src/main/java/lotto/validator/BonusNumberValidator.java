package lotto.validator;

import static lotto.Exception.DUPLICATE_BONUS_NUMBER;

import java.util.List;

public class BonusNumberValidator extends NumberValidator {
    public static void validate(int bonusNumber, List<Integer> numbers) {
        validateRange(bonusNumber);
        validateBonusNumberDuplication(numbers, bonusNumber);
    }

    private static void validateBonusNumberDuplication(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
