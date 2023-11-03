package lotto.model;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isInvalidRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (isInvalidRange) {
            throw new IllegalArgumentException();
        }
    }

    public Integer count(Lotto winningLotto) {
        return (int) IntStream.range(0, 6)
                .filter(i -> winningLotto.contains(numbers.get(i)))
                .count();
    }

    public Boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
