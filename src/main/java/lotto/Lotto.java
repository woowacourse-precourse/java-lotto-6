package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        new Exception().validateNumbersSize(numbers);
    }

    private void validateNumbersDuplication(List<Integer> numbers) {
        new Exception().validateDuplicateNumber(numbers);
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            new Exception().validateNumberRange(number);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
