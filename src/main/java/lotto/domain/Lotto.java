package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidNumberException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static void duplicateValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new DuplicateNumberException();
            }
            uniqueNumbers.add(number);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
