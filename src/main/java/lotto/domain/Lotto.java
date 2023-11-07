package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String FIRST_ERROR_MESSAGE = "[ERROR]";
    private static final String NUMBERS_SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String NUMBERS_DUPLICATE_EXCEPTION_MESSAGE = "로또 번호는 중복될 수 없습니다.";
    private static final String NUMBERS_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (isValidNumbersSize(numbers)) {
            throw new IllegalArgumentException(FIRST_ERROR_MESSAGE+NUMBERS_SIZE_EXCEPTION_MESSAGE);
        }

        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(FIRST_ERROR_MESSAGE+NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }

        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(FIRST_ERROR_MESSAGE+NUMBERS_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < LOTTO_SIZE;
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream()
            .allMatch(i -> i >= LOTTO_NUMBER_MIN && i <= LOTTO_NUMBER_MAX);
    }

    private boolean isValidNumbersSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
