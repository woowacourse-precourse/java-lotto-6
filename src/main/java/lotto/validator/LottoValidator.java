package lotto.validator;

import static lotto.constant.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;
import static lotto.constant.ErrorMessage.NUMBER_COUNT_DIFFERENT_MESSAGE;
import static lotto.constant.ErrorMessage.OVER_VALUE_RANGE_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.Output;

public class LottoValidator {
    public static void numbersSizeDifferent(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            Output.errorMessage(NUMBER_COUNT_DIFFERENT_MESSAGE);
            throw new IllegalArgumentException(NUMBER_COUNT_DIFFERENT_MESSAGE);
        }
    }

    public static void numbersDuplicated(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>();
        numbers.forEach((number) -> {
            if (isDuplicated(checkNumbers, number)) {
                Output.errorMessage(DUPLICATED_NUMBER_MESSAGE);
                throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE);
            }
        });
    }

    private static boolean isDuplicated(Set<Integer> checkNumbers, int number) {
        return !checkNumbers.add(number);
    }

    public static void numbersOverValueRange(List<Integer> numbers) {
        numbers.forEach(LottoValidator::numberOverValueRange);
    }

    public static void numberOverValueRange(int number) {
        if ((number > MAX_LOTTO_NUMBER) || (number < MIN_LOTTO_NUMBER)) {
            Output.errorMessage(OVER_VALUE_RANGE_MESSAGE);
            throw new IllegalArgumentException(OVER_VALUE_RANGE_MESSAGE);
        }
    }
}
