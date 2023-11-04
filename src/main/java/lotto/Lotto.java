package lotto;

import static lotto.exception.Message.LOTTO_OUT_OF_SIZE_EXCEPTION;
import static lotto.exception.Message.NUMBER_DUPLICATION_EXCEPTION;
import static lotto.exception.Message.NUMBER_OUT_OF_RANGE_EXCEPTION;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (outOfSize(numbers)) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_SIZE_EXCEPTION);
        }
    }

    private boolean outOfSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (isDuplicated(uniqueNumbers)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isDuplicated(Set<Integer> uniqueNumbers) {
        return uniqueNumbers.size() != 6;
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(Integer number) {
        if (outOfRange(number)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_EXCEPTION);
        }
    }

    private boolean outOfRange(Integer number) {
        return number < 1 || number > 45;
    }

    public boolean isOverlapping(int bonusNumber) {
        return this.numbers.stream().anyMatch(number -> isSame(bonusNumber, number));
    }

    private boolean isSame(int bonusNumber, Integer number) {
        return bonusNumber == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
