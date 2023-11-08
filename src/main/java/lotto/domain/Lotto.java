package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.errors.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateRangeOfNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LUCKY_NUMBER_COUNT.getMessage());
        }
    }
    
    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NO_DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
