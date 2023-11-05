package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
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
}
