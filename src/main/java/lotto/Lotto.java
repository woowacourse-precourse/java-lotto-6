package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (isValidLength(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }
}
