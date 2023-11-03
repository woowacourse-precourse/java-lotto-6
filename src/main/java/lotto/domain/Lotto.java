package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_MESSAGE_INVALID_SIZE = "[ERROR] 로또는 6자리로 이루어져야 합니다.";
    private static final String ERROR_MESSAGE_INVALID_RANGE = "[ERROR] 로또는 1에서 45사이 입니다.";
    private static final String ERROR_MESSAGE_DUPLICATE_NUMBERS = "[ERROR] 로또에 중복 숫자가 있으면 안됩니다.";

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_SIZE);
        }
    }

    private void validateRange(final List<Integer> numbers) {
        if (!isAllValidRange(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_RANGE);
        }
    }

    private boolean isAllValidRange(final List<Integer> numbers) {
        return numbers.stream()
                .allMatch(this::isValidRange);
    }

    private boolean isValidRange(final Integer number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    private void validateDuplicates(final List<Integer> numbers) {
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBERS);
        }
    }

    private static boolean hasDuplicates(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
