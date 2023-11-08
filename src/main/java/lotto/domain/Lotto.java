package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumbersInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요");
        }
    }

    // TODO: 추가 기능 구현
    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }
    }

    public void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                throw new IllegalArgumentException("숫자는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
