package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.config.Config;
import lotto.view.ErrorMessage;

public class NumberValidator {
    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean hasDuplicate = numbers.stream()
        .anyMatch(number -> !uniqueNumbers.add(number));
        if (hasDuplicate) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIX_NUMBERS);
        }
    }
    
    public static void validateNumberRange(int bonusNumber) {
        if (bonusNumber > Config.LOTTO_MAX_VALUE || bonusNumber < Config.LOTTO_MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_OUR_OF_RANGE);
        }
    }

    public static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIX_NUMBERS);
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

    public static void validateBonusNumberContainsWinningNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SEVEN_NUMBERS);
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
