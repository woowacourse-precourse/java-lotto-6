package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private static final Integer LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        validateSize(numbers);
        validateNumbersRange(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLotto() {
        return this.numbers;
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumber(number);
        }
    }

    private static void validateNumber(int number) {
        if (number > END_NUMBER || number < START_NUMBER) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {

        Set<Integer> notDuplicateNumbers = new HashSet<>();

        for (int number : numbers) {
            notDuplicateNumbers.add(number);
        }

        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }
}
