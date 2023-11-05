package lotto.domain.lottery;

import lotto.exception.LottoException;

import java.util.List;
import java.util.Objects;

import static lotto.domain.constants.LottoConstraint.LOTTO_PICK_COUNT;
import static lotto.exception.ErrorMessage.NUMBER_DUPLICATED;

public sealed class Lotto permits Jackpot {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    private void validateNumbers(final List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw LottoException.from(NUMBER_DUPLICATED);
        }
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
