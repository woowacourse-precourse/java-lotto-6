package lotto.domain.model;

import java.util.List;
import lotto.constant.IllegalArgumentExceptionType;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateAmount(numbers);
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() { return numbers; }

    public boolean contains(int number) { return numbers.contains(number); }
    private boolean hasInvalidSize(int size) {
        return size != LOTTO_SIZE;
    }

    private void validateAmount(List<Integer> numbers) {
        if (hasInvalidSize(numbers.size())) {
            throw IllegalArgumentExceptionType.NUMBER_AMOUNT_INVALID.getException();
        }
    }

    private int getDistinctCount(List<Integer> numbers) {
        return Long.valueOf(numbers.stream().distinct().count()).intValue();
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        int distinctCount = getDistinctCount(numbers);

        if (hasInvalidSize(distinctCount)) {
            throw IllegalArgumentExceptionType.DUPLICATED_NUMBER_ERROR.getException();
        }
    }
}
