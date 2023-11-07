package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String EMPTY_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호가 비었습니다.";
    private static final String INCORRECT_LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 %d개여야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 %d부터 %d 사이의 수여야 합니다.";
    private static final String DUPLICATE_LOTTO_NUMBER_ERROR = "[ERROR] 로또의 각 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateEmpty(numbers);
        validateSixNumbersCount(numbers);
        validateInvalidLottoNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validateEmpty(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_NUMBER_ERROR);
        }
    }

    private void validateSixNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format(INCORRECT_LOTTO_NUMBER_COUNT_ERROR, LOTTO_NUMBER_SIZE));
        }
    }

    private void validateInvalidLottoNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_RANGE_ERROR, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>();
        if (numbers.stream().anyMatch(number -> !checkNumbers.add(number))) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR);
        }
    }
}
