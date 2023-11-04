package lotto.domain;

import java.util.List;
import lotto.constant.ExceptionMessage;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SIX_NUMBER.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num > MAX_LOTTO_NUMBER || num < MIN_LOTTO_NUMBER)
                .findAny()
                .ifPresent(num -> {
                    throw new IllegalArgumentException(ExceptionMessage.INPUT_CORRECT_RANGE.getMessage());
                });
    }

}
