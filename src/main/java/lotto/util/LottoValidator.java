package lotto.util;

import static lotto.domain.enums.LottoConstants.LOTTO_SIZE;
import static lotto.domain.enums.LottoConstants.MAX_LOTTO_NUM;
import static lotto.domain.enums.LottoConstants.MIN_LOTTO_NUM;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.InvalidLottoNumberRangeException;
import lotto.exception.InvalidLottoSizeException;

public class LottoValidator {
    public static void validateNumbersRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> validateNumberRange(number));
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new InvalidLottoNumberRangeException();
        }
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    public static void validateDuplicateLottoNumbers(List<Integer> numbers) {
        Set<Integer> unDuplicatedNumbers = new HashSet<>(numbers);
        if (unDuplicatedNumbers.size() != numbers.size()) {
            throw new DuplicatedLottoNumberException();
        }
    }
}
