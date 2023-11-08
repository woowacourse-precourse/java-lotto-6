package lotto.validation;

import lotto.utils.GameUtilConstants;

public class WinningNumberValidator {

    private WinningNumberValidator() {
    }

    public static void validateWinningNumbers(String winningNumbers) {
        isMultiple(winningNumbers);
    }

    private static void isMultiple(String winningNumbers) {
        if (!winningNumbers.contains(GameUtilConstants.LEST_DELIMITER.getValue())) {
            throw WinningNumberException.INVALID_MULTIPLE_EXCEPTION.getException();
        }
    }
}
