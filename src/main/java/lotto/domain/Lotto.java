package lotto.domain;

import java.util.List;

import static lotto.constants.Error.*;
import static lotto.constants.Rule.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateRange(numbers);
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !isValidNumber(number))) {
            throw new IllegalArgumentException(RANGE_INVALID.getMessage());
        }
    }

    private static boolean isValidNumber(int number) {
        return number >= MIN_LOTTO.getValue() && number <= MAX_LOTTO.getValue();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(SIZE_INVALID.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_INVALID.getMessage());
        }
    }

    public int countNumbers(Lotto prize) {
        return (int) numbers.stream().filter(prize::containNumber).count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
