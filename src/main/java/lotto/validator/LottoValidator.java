package lotto.validator;

import static lotto.constant.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;
import static lotto.constant.ErrorMessage.NOT_MATCH_COUNT_MESSAGE;
import static lotto.constant.ErrorMessage.OVER_VALUE_RANGE_MESSAGE;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.Output;

public class LottoValidator {
    public static void numbersSizeCorrect(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            Output.errorMessage(NOT_MATCH_COUNT_MESSAGE);
            throw new IllegalArgumentException(NOT_MATCH_COUNT_MESSAGE);
        }
    }

    public static void numbersDuplication(List<Integer> numbers) {
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

    public static void numberOverValueRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if ((number > MAX_LOTTO_NUMBER) || (number < MIN_LOTTO_NUMBER)) {
                Output.errorMessage(OVER_VALUE_RANGE_MESSAGE);
                throw new IllegalArgumentException(OVER_VALUE_RANGE_MESSAGE);
            }
        });
    }
}
