package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (duplicateValidate(numbers)) {
            throw new IllegalArgumentException();
        }
        numRangeValidate(numbers);
    }

    private static void numRangeValidate(List<Integer> numbers) {
        boolean outOfRange = numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER);
        if (outOfRange)
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private boolean duplicateValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
