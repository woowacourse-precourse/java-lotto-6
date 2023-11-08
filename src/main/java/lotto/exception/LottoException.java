package lotto.exception;

import static lotto.utility.Constants.ERROR_MESSAGE_1;
import static lotto.utility.Constants.LOTTO_LENGTH;

import java.util.List;

public class LottoException {
    private LottoException() {}
    public static void validateLottoAll(List<Integer> numbers) {
        validateLottoLength(numbers);
    }
    private static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_1);
        }
    }
}
