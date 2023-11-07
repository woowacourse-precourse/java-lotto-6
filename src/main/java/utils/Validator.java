package utils;

import type.ErrorType;

import java.util.List;

public class Validator {
    public static void checkLottoSizeNumberInput(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_DIGITS.getText());
        }
    }

    public static void checkLottoDuplicatedNumberInput(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_DUPLICATED.getText());
        }
    }

    public static void checkLottoBonusNumber(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException(ErrorType.INVALID_BONUS_NUMBER_DUPLICATED.getText());
            }
        }
    }
}
