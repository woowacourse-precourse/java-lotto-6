package lotto.utils;

import lotto.enums.Constants;
import lotto.enums.Messages;

import java.util.List;

public class ValidateCheck {
    public static void numberCountValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Messages.NUMBER_COUNT_ERROR_MESSAGE.getMessage());
        }
    }

    public static void numberDupulicationValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Messages.NUMBER_DUPULICATE_MESSAGE.getMessage());
        }
    }

    public static void isNumberExist(int targetNumber, List<Integer> numbers) {
        if (numbers.contains(targetNumber)) {
            throw new IllegalArgumentException(Messages.NUMBER_DUPULICATE_MESSAGE.getMessage());
        }
    }

    public static void numbersRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            numberRangeValidate(number);
        }
    }

    public static void numberRangeValidate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Messages.NUMBER_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    public static void pureIntegerCheck(String number) {
        try {
            int convertNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.PURE_INTEGER_ERROR_MESSAGE.getMessage());
        }
    }

    public static void inputAmountValidate(int amount) {
        if (amount % Constants.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(Messages.PRICE_DEVIDE_ERROR_MESSAGE.getMessage());
        }
    }
}
