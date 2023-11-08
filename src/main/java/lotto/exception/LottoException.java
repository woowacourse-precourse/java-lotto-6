package lotto.exception;

import static lotto.utility.Constants.ERROR_MESSAGE_1;
import static lotto.utility.Constants.ERROR_MESSAGE_3;
import static lotto.utility.Constants.ERROR_MESSAGE_4;
import static lotto.utility.Constants.LOTTO_LENGTH;

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
            throw new IllegalArgumentException(ERROR_MESSAGE_3);
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0 || number > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE_1);
            }
        }
    }

    private static void validateLottoDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_4);
        }
    }
}
