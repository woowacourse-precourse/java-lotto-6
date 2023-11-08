package lotto.model.validator;

import static lotto.util.ExceptionMessage.BIGGER_THAN_MAX_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.util.ExceptionMessage.SMALLER_THAN_MIN_LOTTO_NUMBER;
import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;

public class LottoNumberValidator {

    public static void checkCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkMinimum(number);
            checkMaximum(number);
        }
    }

    private static void checkMinimum(Integer number) {
        if (number < MINIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(SMALLER_THAN_MIN_LOTTO_NUMBER.getMessage());
        }
    }

    private static void checkMaximum(Integer number) {
        if (number > MAXIMUM_OF_LOTTO_NUMBER.getDetails()) {
            throw new IllegalArgumentException(BIGGER_THAN_MAX_LOTTO_NUMBER.getMessage());
        }
    }

    public static void checkDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
