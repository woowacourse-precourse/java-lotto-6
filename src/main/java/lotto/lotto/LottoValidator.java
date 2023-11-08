package lotto.lotto;

import java.util.HashSet;
import java.util.List;
import lotto.message.ErrorMessage;

public class LottoValidator {

    public static final int LOTTO_MIN_NUM = 1;
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_NUM_SIZE = 6;

    private LottoValidator() {
    }

    public static void validateNumbers(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        numbers.forEach(LottoValidator::validateNumber);
    }

    private static void checkDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUM_DUPLICATE);
        }
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUM_SIZE);
        }
    }

    public static void validateNumber(int number) {
        if (number > LOTTO_MAX_NUM || number < LOTTO_MIN_NUM) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUM_SCOPE);
        }
    }
}
