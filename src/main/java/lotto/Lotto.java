package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        numbers = numbers.stream()
                .distinct()
                .toList();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        numbers = numbers.stream()
                .filter(number -> number >= 1 && number <= 45)
                .toList();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().toList();
    }
}
