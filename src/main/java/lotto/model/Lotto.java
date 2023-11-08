package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                ErrorMessage.INVALID_NUMBERS_COUNT_ERROR.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean isOutOfRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_LOTTO_RANGE_ERROR.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> duplicateNumbers = numbers.stream()
            .filter(number -> !uniqueNumbers.add(number))
            .collect(Collectors.toList());

        if (!duplicateNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
