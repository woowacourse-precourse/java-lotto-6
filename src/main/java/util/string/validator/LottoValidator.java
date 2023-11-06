package util.string.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.OutOfNumberRangeException;

public class LottoValidator {
    private static final int LOTTO_NUMBER_MIN_RANGE = 1;
    private static final int LOTTO_NUMBER_MAX_RANGE = 45;

    private LottoValidator() {
    }

    public static void checkLottoNumberDuplicatedAndThrowException(List<Integer> numbers)
            throws IllegalArgumentException {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new DuplicatedLottoNumberException();
        }
    }

    public static void checkLottoNumberRangeAndThrowException(List<Integer> numbers) throws IllegalArgumentException {

        for (int x : numbers) {
            if (x > LOTTO_NUMBER_MAX_RANGE || x < LOTTO_NUMBER_MIN_RANGE) {
                throw new OutOfNumberRangeException();
            }
        }
    }
}
