package lotto.domain;

import lotto.exception.DuplicateInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.ServiceConstants.NUMBER_STANDARD;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_STANDARD) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicate(numbers)) {
            throw new DuplicateInputException();
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
