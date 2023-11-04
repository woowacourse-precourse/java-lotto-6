package lotto.model;

import lotto.constant.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isInvalidRange = numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (isInvalidRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public Integer count(Lotto lotto) {
        return (int) IntStream.range(0, 6)
                .filter(i -> lotto.contains(numbers.get(i)))
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
