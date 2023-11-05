package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int NUMBERS_LENGTH = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 존재할 수 없습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 숫자만 가능합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicationInNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateDuplicationInNumbers(final List<Integer> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private boolean hasDuplication(final List<Integer> numbers) {
        return NUMBERS_LENGTH != numbers.stream()
                .distinct()
                .count();
    }

    private void validateNumberRange(final List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(this::hasOutOfRangeNumber)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private boolean hasOutOfRangeNumber(final int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public boolean hasNumber(final int number) {
        return numbers.contains(number);
    }

    @Override
    public boolean equals(final Object o) {
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
