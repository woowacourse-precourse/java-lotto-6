package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.exception.ExceptionMessage;

import java.util.List;

import static lotto.domain.Lotto.LOTTO_NUMBERS_LENGTH;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBERS_DUPLICATED;

public class LottoValidator {

    private LottoValidator() {
        throw new AssertionError();
    }

    public static void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw ExceptionMessage.LOTTO_NUMBERS_LENGTH.getException();
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        if (getDistinctLength(numbers) != LOTTO_NUMBERS_LENGTH) {
            throw LOTTO_NUMBERS_DUPLICATED.getException();
        }
    }

    public static void validateDuplicatedBonusNumber(Lotto numbers, LottoNumber number) {
        if (numbers.getNumbers().contains(number)) {
            throw ExceptionMessage.LOTTO_NUMBERS_DUPLICATED.getException();
        }
    }

    private static long getDistinctLength(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }
}
