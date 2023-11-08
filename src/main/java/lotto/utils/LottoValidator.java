package lotto.utils;

import java.util.List;

public class LottoValidator {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private LottoValidator() {
    }

    public static void validateOutOfRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(MessageConstant.LOTTO_OUT_OF_RANGE);
            }
        }
    }

    public static void validateOutOfRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(MessageConstant.LOTTO_OUT_OF_RANGE);
        }
    }

    private static boolean isOutOfRange(int number) {
        return number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER;
    }
}
