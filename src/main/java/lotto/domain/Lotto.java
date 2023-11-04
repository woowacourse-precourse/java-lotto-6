package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final String LENGTH_VALID_LOG = "6개의 번호를 입력해주세요.";
    public static final String DUPLICATE_VALID_LOG = "중복 없이 입력해주세요.";
    public static final String NUMBER_RANGE_VALID_LOG = "1 부터 45 사이의 숫자만 입력해주세요.";
    public static final int LOTTO_SIZE_NUMBER = 6;
    public static final int LOTTO_START_RANGE = 1;
    public static final int LOTTO_END_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLength(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_NUMBER) {
            throw new IllegalArgumentException(LENGTH_VALID_LOG);
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> validator = new HashSet<>(numbers);
        if (validator.size() < LOTTO_SIZE_NUMBER) {
            throw new IllegalArgumentException(DUPLICATE_VALID_LOG);
        }
    }

    private void validateRange(final List<Integer> numbers) {
        boolean invalid = numbers.stream().anyMatch(num -> num < LOTTO_START_RANGE || num > LOTTO_END_RANGE);
        if (invalid) {
            throw new IllegalArgumentException(NUMBER_RANGE_VALID_LOG);
        }
    }
}
