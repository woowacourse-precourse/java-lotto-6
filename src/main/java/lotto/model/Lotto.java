package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final int NUMBER_COUNT = 6;
    public static final String ERROR_MESSAGE_INVALID_COUNT = "로또 번호는 6개여야 합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_NUMBER = "중복되는 번호가 있어서는 안됩니다.";
    public static final String ERROR_MESSAGE_INVALID_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);

        validateCount(sortedNumbers);
        hasDuplicateNumber(sortedNumbers);
        validRange(sortedNumbers);

        sortNumbers(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_COUNT);
        }
    }

    private void hasDuplicateNumber(List<Integer> numbers) {
        Set<Integer> exceptDuplicateNumber = new HashSet<>(numbers);

        if (exceptDuplicateNumber.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBER);
        }
    }

    private void validRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !(number >= MIN_RANGE && number <= MAX_RANGE))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_RANGE);
        }
    }

    public boolean contains(int targetNumber) {
        return numbers.contains(targetNumber);
    }

    public void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto other = (Lotto) o;
        return Objects.equals(numbers, other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}