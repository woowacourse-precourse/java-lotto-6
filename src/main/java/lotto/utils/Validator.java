package lotto.utils;

import static lotto.constants.Error.DIVIDE_INVALID;
import static lotto.constants.Error.DUPLICATE_INVALID;
import static lotto.constants.Error.MINIMUM_INVALID;
import static lotto.constants.Error.RANGE_INVALID;
import static lotto.constants.Error.SIZE_INVALID;
import static lotto.constants.Rule.LOTTO_SIZE;
import static lotto.constants.Rule.MAX_LOTTO;
import static lotto.constants.Rule.MIN_LOTTO;
import static lotto.constants.Rule.MIN_MONEY;

import java.util.List;

public class Validator {
    public static void validateLottoSize(List<Integer> numbers) {
        if (hasValidSize(numbers, LOTTO_SIZE.getValue())) {
            return;
        }
        throw new IllegalArgumentException(SIZE_INVALID.getMessage());
    }

    public static void validateLottoRange(int number) {
        if (isNumberInRange(number)) {
            return;
        }
        throw new IllegalArgumentException(RANGE_INVALID.getMessage());
    }

    public static void validateLottoDuplicates(List<Integer> numbers) {
        if (hasValidSize(numbers, numbers.size())) {
            return;
        }
        throw new IllegalArgumentException(DUPLICATE_INVALID.getMessage());
    }

    public static void validateMinimumAmount(int money) {
        if (isAmountAboveMinimum(money)) {
            return;
        }
        throw new IllegalArgumentException(MINIMUM_INVALID.getMessage());
    }

    public static void validateDivisibleAmount(int money) {
        if (isAmountDivisible(money)) {
            return;
        }
        throw new IllegalArgumentException(DIVIDE_INVALID.getMessage());
    }

    private static boolean hasValidSize(List<Integer> numbers, int size) {
        return numbers.stream().distinct().count() == size;
    }

    private static boolean isNumberInRange(int number) {
        return number >= MIN_LOTTO.getValue() && number <= MAX_LOTTO.getValue();
    }

    private static boolean isAmountAboveMinimum(int money) {
        return money >= MIN_MONEY.getValue();
    }

    private static boolean isAmountDivisible(int money) {
        return money % MIN_MONEY.getValue() == 0;
    }
}
