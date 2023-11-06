package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortNumbersAscending();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void sortNumbersAscending() {
        Collections.sort(numbers);
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
