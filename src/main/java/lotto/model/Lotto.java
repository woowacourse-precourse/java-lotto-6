package lotto.model;

import java.util.List;

public class Lotto {
    private final String OPEN_BRACKET = "[";
    private final String CLOSE_BRACKET = "]";
    private final String DELIMITER = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    @Override
    public String toString() {
        return OPEN_BRACKET
                + String.join(DELIMITER, numbers.stream().map(String::valueOf).toList())
                + CLOSE_BRACKET;
    }
}
