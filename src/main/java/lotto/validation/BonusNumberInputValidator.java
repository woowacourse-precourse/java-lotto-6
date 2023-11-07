package lotto.validation;

import java.util.List;
import lotto.utils.Constants;

public class BonusNumberInputValidator {
    public static void validate(String input, List<Integer> winningNumbers) {
        validateIsNumeric(input);
        int bonusNumber = Integer.parseInt(input);
        validateIsInRange(bonusNumber);
        validateIsNotDuplicate(bonusNumber, winningNumbers);
    }

    private static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Constants.INVALID_BONUS_NUMBER_MSG);
        }
    }

    private static void validateIsInRange(int number) {
        if (number < Constants.LOTTO_NUM_MIN || number > Constants.LOTTO_NUM_MAX) {
            throw new IllegalArgumentException(Constants.INVALID_BONUS_NUMBER_MSG);
        }
    }

    private static void validateIsNotDuplicate(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(Constants.DUPLICATE_BONUS_NUMBER_MSG);
        }
    }
}
