package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_SIZE_IS_NOT_6.getMessage());
        }
    }

    private void hasDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        sb.append("]");

        return sb.toString();
    }
}
