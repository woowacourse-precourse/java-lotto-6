package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sort();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private void validate(List<Integer> numbers) {
        validateSizeFrom(numbers);
        validateDuplicateFrom(numbers);
    }

    private void validateSizeFrom(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.INVALID_NUMBER_LENGTH.message);
        }
    }

    private void validateDuplicateFrom(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .findAny()
                .isPresent()) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX +ErrorMessage.INVALID_DUPLICATE_NUMBER.message);
        }
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
