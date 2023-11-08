package lotto.validator;

import lotto.constant.LottoConstants;

import java.util.List;

public class LottoValidator {
    public static void isInvalidSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.TOTAL_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInvalidNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number > LottoConstants.MAX_LOTTO_NUMBER
                || number < LottoConstants.MIN_LOTTO_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
