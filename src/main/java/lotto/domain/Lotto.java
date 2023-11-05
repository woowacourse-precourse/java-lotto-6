package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
        validateDuplicate(numbers);
        numRangeValidate(numbers);
    }

    private static void numRangeValidate(List<Integer> numbers) {
        boolean outOfRange = numbers.stream().anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER);
        if (outOfRange)
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private static void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
