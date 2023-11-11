package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() < Constants.LOTTO_LENGTH) {
            throw new IllegalArgumentException(Constants.DUPLICATE_NUMBER_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "[" +
                numbers.stream().sorted()
                .map(number -> Integer.toString(number))
                .collect(Collectors.joining(", "))
                + "]";
    }
}
