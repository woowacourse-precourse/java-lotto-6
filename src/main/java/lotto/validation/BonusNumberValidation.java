package lotto.validation;

import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;

import java.util.List;

public class BonusNumberValidation {
    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        WinningNumbersValidation.validateNumberInRange(bonusNumber);
        validateDuplication(bonusNumber, winningNumber);
    }

    private static void validateDuplication(int bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }
}
