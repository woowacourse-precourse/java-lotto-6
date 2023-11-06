package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateOutOfSize(numbers);
        validateDuplication(numbers);
        validateOutOfRange(numbers);
    }

    private void validateOutOfSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOutOfRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
