package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
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
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_NUMBER_LENGTH.message);
        }
    }

    private void validateDuplicateFrom(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.INVALID_DUPLICATE_NUMBER.message);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
