package lotto;

import static lotto.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.ErrorMessage.NOT_IN_RANGE;
import static lotto.ErrorMessage.NOT_SORT;
import static lotto.ErrorMessage.OUT_OF_SIZE;
import static lotto.LottoRule.MAXIMUM;
import static lotto.LottoRule.MINIMUM;
import static lotto.LottoRule.SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
        validateSort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE.getValue()) {
            throw new IllegalArgumentException(OUT_OF_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != SIZE.getValue()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        if (isNotNumberInRange(numbers)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getMessage());
        }
    }

    private boolean isNotNumberInRange(List<Integer> numbers) {
        return !numbers.stream().allMatch(number ->
                number >= MINIMUM.getValue() && number <= MAXIMUM.getValue());
    }

    private void validateSort(List<Integer> numbers) {
        if (isNotSorted(numbers)) {
            throw new IllegalArgumentException(NOT_SORT.getMessage());
        }
    }

    private boolean isNotSorted(List<Integer> numbers) {
        List<Integer> sortedNumber = new ArrayList<>(numbers);
        Collections.sort(sortedNumber);
        return !numbers.equals(sortedNumber);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
