package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_SIZE.getMessage());
        }
        for (Integer number : numbers) {
            validateRange(number);
        }
        validateDuplication(numbers);
    }

    public void validateRange(Integer number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        Set<Integer> validateNumbers = new HashSet<>(numbers);
        if (validateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
