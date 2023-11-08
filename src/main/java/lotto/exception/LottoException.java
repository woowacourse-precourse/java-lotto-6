package lotto.exception;

import static lotto.utility.Constants.ERROR_MESSAGE_2;

import static lotto.utility.Constants.LOTTO_LENGTH;
import static lotto.utility.Constants.MAX_LOTTO_NUMBER;
import static lotto.utility.Constants.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;

public class LottoException {
    private LottoException() {}
    public static void validateLottoAll(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoNumberRange(numbers);
        validateLottoDuplicate(numbers);
    }

    private static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_2);
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ERROR_MESSAGE_2);
            }
        }
    }

    private static void validateLottoDuplicate(List<Integer> numbers) {
        if (numbers.size() != (new HashSet<>(numbers).size())) {
            throw new IllegalArgumentException(ERROR_MESSAGE_2);
        }
    }
}
