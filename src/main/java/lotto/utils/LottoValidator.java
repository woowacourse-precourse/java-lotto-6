package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ExceptionMessage;

public class LottoValidator {

    private static final int MONEY_UNIT = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int WINNING_NUMBERS_COUNT = 6;

    public void validatePurchaseAmount(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_UNIT_ERROR.message);
        }
    }

    public int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_VALUE_ERROR.message);
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                String error = String.format(ExceptionMessage.NUMBER_RANGE_ERROR.message, MIN_NUMBER, MAX_NUMBER);
                throw new IllegalArgumentException(error);
            }
        }
    }

    public void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_ERROR.message);
        }
    }

    public void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_COUNT) {
            String error = String.format(ExceptionMessage.NUMBER_COUNT_ERROR.message, WINNING_NUMBERS_COUNT);
            throw new IllegalArgumentException(error);
        }
    }
}
