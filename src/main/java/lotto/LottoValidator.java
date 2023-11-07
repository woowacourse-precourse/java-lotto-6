package lotto;

import static lotto.Constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;
import static lotto.exception.ErrorCode.LOTTO_NUMBER_DUPLICATE;
import static lotto.exception.ErrorCode.LOTTO_NUMBER_RANGE;
import static lotto.exception.ErrorCode.LOTTO_NUMBER_SIZE;

import java.util.List;
import lotto.exception.LottoException;

public class LottoValidator {

    public static void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNotDuplicate(numbers);
        validateNumbersRange(numbers);
    }

    private static void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoException(LOTTO_NUMBER_SIZE);
        }
    }

    private static void validateNotDuplicate(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATE);
        }
    }

    private static void validateNumbersRange(final List<Integer> numbers) {
        numbers.forEach(LottoValidator::validateNumberRange);
    }

    private static void validateNumberRange(final int number) {
        if (number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
            throw new LottoException(LOTTO_NUMBER_RANGE);
        }
    }

    private static boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
