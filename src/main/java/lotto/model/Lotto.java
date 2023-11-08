package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumbers(numbers);
        validateOutRange(numbers);

        List<Integer> validnumbers = new ArrayList<>(numbers);
        Collections.sort(validnumbers);

        this.numbers = validnumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOutRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(outRangeNumber -> {
                    throw new IllegalArgumentException();
                });
    }

    public List<Integer> toList() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
