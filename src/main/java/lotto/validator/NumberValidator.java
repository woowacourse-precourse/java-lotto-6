package lotto.validator;

import java.util.List;
import java.util.Set;

import lotto.config.Config;
import lotto.view.ErrorMessage;

public class NumberValidator {
    public static void validateWinnerNumberSize(Set<Integer> numbers) {
        if (numbers.size() != Config.LOTTO_SIZE_WITHOUT_BONUS_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateUserNumbersSize(List<Integer> numbers) {
        if (numbers.size() != Config.LOTTO_SIZE_WITHOUT_BONUS_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinnerNumberSizeContainsBonusNumber(Set<Integer> numbers) {
        if (numbers.size() != Config.LOTTO_SIZE_CONTAIN_BONUS_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputWinningNumber(String[] winningNumber) {
        try {
            for (int i = 0; i < winningNumber.length; i++) {
                Integer.parseInt(winningNumber[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT);
        }
    }

    public static void validateNumberRange(int bonusNumber) {
        if (bonusNumber > Config.LOTTO_MAX_VALUE || bonusNumber < Config.LOTTO_MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_OUR_OF_RANGE);
        }
    }

    public static void validateInputBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT);
        }
    }
}
