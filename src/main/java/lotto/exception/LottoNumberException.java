package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.exception.ErrorMessage.*;

abstract public class LottoNumberException {
    public static void validate(List<Integer> numbers) {
        lottoSizeValidate(numbers);
        lottoNumberDuplicateValidate(numbers);
    }

    private static void lottoSizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR.printMessage() + LOTTO_SIZE.printMessage());
        }
    }

    private static void lottoNumberDuplicateValidate(List<Integer> numbers) {
        Set<Integer> validate = new HashSet<>(numbers);

        if (validate.size() != 6) {
            throw new IllegalArgumentException(ERROR.printMessage() + LOTTO_DUPLICATE.printMessage());
        }
    }
}
