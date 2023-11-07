package utils;

import type.ErrorType;

import java.util.List;

public class Validator {

    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 0;

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
            if (number == bonusNumber || number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorType.INVALID_BONUS_NUMBER_DUPLICATED.getText());
            }
        }
    }

    public static void checkMoney(int money) {
        if (money % 1000 != MIN_NUMBER || money <= MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorType.INVALID_PRICE_INPUT.getText());
        }
    }
}
