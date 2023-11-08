package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_NUMBERS_RANGE_START = 1;
    private static final int LOTTO_NUMBERS_RANGE_END = 45;
    private static final String LOTTO_NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되는 값이 존재하지 않아야 합니다.";
    private static final String LOTTO_NUMBERS_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        Set duplicateCheck = new HashSet(numbers);
        if (duplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateSingleNumberRange(number);
        }
    }

    private void validateSingleNumberRange(int number) {
        if (number > LOTTO_NUMBERS_RANGE_END || number < LOTTO_NUMBERS_RANGE_START) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_ERROR_MESSAGE);
        }
    }
}
