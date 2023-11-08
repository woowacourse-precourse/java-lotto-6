package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.utils.Constant.COUNT_OF_LOTTO;

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
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        return numbers.stream().anyMatch(n -> !uniqueNumbers.add(n));
    }

}
