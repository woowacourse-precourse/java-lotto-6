package utils;

import error.*;
import type.ErrorType;

import java.util.List;

public class Validator {

    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 0;

    public static void checkLottoSizeNumberInput(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ErrorType.INVALID_NUMBER_DIGITS.getText());
            throw new NotValidLottoSizeException();
        }
    }

    public static void checkLottoDuplicatedNumberInput(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()) {
            System.out.println(ErrorType.INVALID_NUMBER_DUPLICATED.getText());
            throw new NotValidDuplicatedLottoException();
        }
    }

    public static void checkLottoBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (bonusNumber <= MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            System.out.println(ErrorType.INVALID_BONUS_NUMBER_RANGE.getText());
            throw new NotValidBonusRangeException();
        }

        for (int number : numbers) {
            if (number == bonusNumber) {
                System.out.println(ErrorType.INVALID_BONUS_NUMBER_DUPLICATED.getText());
                throw new NotValidBonusDuplicatedException();
            }
        }
    }

    public static void checkMoney(int money) {
        if (money % 1000 != MIN_NUMBER || money <= MIN_NUMBER) {
            System.out.println(ErrorType.INVALID_PRICE_INPUT.getText());
            throw new NotValidMoneyInputException();
        }
    }
}
