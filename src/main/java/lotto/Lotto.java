package lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final int MIN_OF_RANGE = 1;
    private static final int MAX_OF_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(number -> number < MIN_OF_RANGE || number > MAX_OF_RANGE)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
