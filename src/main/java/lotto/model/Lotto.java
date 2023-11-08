package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_LOTTO) {
            throw new IllegalArgumentException();
        }
        if (isDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!isValidNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        return numbers.stream().anyMatch(n -> !uniqueNumbers.add(n));
    }

    private boolean isValidNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < SD_RANDOM_NUMBER_MIN || number > SD_RANDOM_NUMBER_MAX) return false;
        }
        return true;
    }
}
