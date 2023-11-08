package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String VALIDATE_COUNT_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String VALIDATE_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String VALIDATE_DUPLICATION_MESSAGE = "[ERROR] 중복된 숫자가 있습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    protected void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(VALIDATE_COUNT_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int a : numbers) {
            if (a < 1 || a > 45) {
                throw new IllegalArgumentException(VALIDATE_RANGE_MESSAGE);
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(VALIDATE_DUPLICATION_MESSAGE);
        }
    }

}
