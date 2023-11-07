package lotto.domain.lotto;

import static lotto.domain.lotto.LottoRule.MAXIMUM;
import static lotto.domain.lotto.LottoRule.MINIMUM;
import static lotto.domain.lotto.LottoRule.SIZE;
import static lotto.util.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.util.ErrorMessage.NOT_IN_RANGE;
import static lotto.util.ErrorMessage.NOT_SORT;
import static lotto.util.ErrorMessage.OUT_OF_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
        validateSort(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != SIZE.getValue()) {
            throw new IllegalArgumentException(OUT_OF_SIZE.getMessage());
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != SIZE.getValue()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumberInRange(final List<Integer> numbers) {
        if (isNotNumberInRange(numbers)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getMessage());
        }
    }

    private boolean isNotNumberInRange(final List<Integer> numbers) {
        return !numbers.stream().allMatch(number ->
                number >= MINIMUM.getValue() && number <= MAXIMUM.getValue());
    }

    private void validateSort(final List<Integer> numbers) {
        if (isNotSorted(numbers)) {
            throw new IllegalArgumentException(NOT_SORT.getMessage());
        }
    }

    private boolean isNotSorted(final List<Integer> numbers) {
        List<Integer> sortedNumber = new ArrayList<>(numbers);
        Collections.sort(sortedNumber);
        return !numbers.equals(sortedNumber);
    }

    public final List<Integer> getNumbers() {
        return this.numbers;
    }
}
