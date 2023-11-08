package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_RANGE_MIN = 1;
    public static final int LOTTO_RANGE_MAX = 45;
    public static final int LOTTO_SIZE = 6;
    public static final String NUMBERS_SIZE_INVALID_EXCEPTION = "로또는 총 " + LOTTO_SIZE + "개의 숫자로 구성되어야 합니다.";
    public static final String NUMBERS_DUPLICATE_EXCEPTION = "로또는 중복되지 않는 숫자로 구성되어야 합니다.";
    public static final String NUMBERS_RANGE_INVALID_EXCEPTION = "로또 번호는 " + LOTTO_RANGE_MIN + "부터 " + LOTTO_RANGE_MAX + " 사이의 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchNumber(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(this::hasNumber)
                .count();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_INVALID_EXCEPTION);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_EXCEPTION);
        }
    }

    private void validateRange(List<Integer> numbers) {
        int validRangeNumber = (int) numbers.stream()
                .filter(n -> LOTTO_RANGE_MIN <= n && n <= LOTTO_RANGE_MAX)
                .count();
        if (validRangeNumber != LOTTO_SIZE) {
            throw new IllegalArgumentException(NUMBERS_RANGE_INVALID_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .toList()
                .toString();
    }
}
