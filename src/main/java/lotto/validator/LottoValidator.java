package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.OutOfNumberRangeException;

public class LottoValidator {

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

        for (int number : numbers) {
            if (number > ValidNumber.LOTTO_NUMBER_MAX_RANGE.getNumber()
                    || number < ValidNumber.LOTTO_NUMBER_MIN_RANGE.getNumber()) {
                throw new OutOfNumberRangeException();
            }
        }
    }
}
