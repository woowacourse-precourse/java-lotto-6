package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (hasInvalidSize(numbers) || hasDuplicatedNumber(numbers)
                || hasInvalidRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasInvalidSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != 6;
    }

    private boolean hasInvalidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number ->
                        number < 1 || number > 45);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
