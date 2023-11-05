package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateAllRange(numbers, MIN_NUMBER, MAX_NUMBER);
        validateNoDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAllRange(List<Integer> numbers, int minNumber, int maxNumber) {
        if (!numbers.stream()
                .allMatch(number -> number >= minNumber && number <= maxNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        if (numbers.stream()
                .anyMatch(number -> set.contains(number))) {
            throw new IllegalArgumentException();
        }
    }
}
