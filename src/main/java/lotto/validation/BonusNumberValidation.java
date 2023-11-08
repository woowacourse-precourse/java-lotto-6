package lotto.validation;

import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;

import java.util.Set;

public class BonusNumberValidation {
    public static void validateBonusNumber(int bonusNumber, Set<Integer> winningNumber) {
        WinningNumbersValidation.validateNumberInRange(bonusNumber);
        validateDuplication(bonusNumber, winningNumber);
    }

    private static void validateDuplication(int bonusNumber, Set<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }
}
