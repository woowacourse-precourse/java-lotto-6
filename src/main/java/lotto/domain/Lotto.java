package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;
import java.util.Objects;

import static lotto.domain.constants.LottoConstraint.*;
import static lotto.exception.ErrorMessage.*;

public sealed class Lotto permits Jackpot {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    private void validateNumberCount(final List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw LottoException.from(NUMBER_COUNT_INVALID);
        }
    }

    private void validateNumberRange(final List<Integer> numbers) {
        if (isInvalidRange(numbers)) {
            throw LottoException.from(NUMBER_OUT_OF_RANGE);
        }
    }

    private static boolean isInvalidRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(Lotto::isOutOfRange);
    }

    private static boolean isOutOfRange(Integer number) {
        return number < NUMBER_LOWER_BOUND.getValue() || number > NUMBER_UPPER_BOUND.getValue();
    }

    private void validateDuplication(final List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw LottoException.from(NUMBER_DUPLICATED);
        }
    }

    private static boolean isInvalidSize(List<Integer> numbers) {
        return !Objects.equals(numbers.size(), LOTTO_PICK_COUNT.getValue());
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        final int uniqueNumberCount = (int) numbers.stream().distinct().count();

        return !Objects.equals(numbers.size(), uniqueNumberCount);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
