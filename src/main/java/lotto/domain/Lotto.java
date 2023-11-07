package lotto.domain;

import static lotto.constant.ExceptionMessage.LOTTO_DUPLICATE_NUMBER_EXCEPTION;
import static lotto.constant.ExceptionMessage.LOTTO_WRONG_RANGE_EXCEPTION;
import static lotto.constant.ExceptionMessage.LOTTO_WRONG_SIZE_EXCEPTION;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isWrongSize(numbers)) {
            throw new IllegalArgumentException(LOTTO_WRONG_SIZE_EXCEPTION.getMessage());
        }

        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_NUMBER_EXCEPTION.getMessage());
        }

        if (isWrongRange(numbers)) {
            throw new IllegalArgumentException(LOTTO_WRONG_RANGE_EXCEPTION.getMessage());
        }
    }

    private boolean isWrongSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != 6;
    }

    private boolean isWrongRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
