package lotto.domain;

import lotto.util.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSixSize(numbers);
        isDuplicateExists(numbers);
        isInRange(numbers);
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static void isInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number >= 1 && number <= 45)) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
            }
        }
    }

    private static void isDuplicateExists(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>(numbers);
        if (numbers.size() != temp.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_EXISTS);
        }
    }

    private static void isSixSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_SIX_SIZE);
        }
    }
}
