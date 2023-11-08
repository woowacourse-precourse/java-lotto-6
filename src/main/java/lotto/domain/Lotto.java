package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String ERROR_SIZE = "[ERROR] 6개의 숫자를 입력해주세요";
    private static final String ERROR_ISDUPLICATE = "[ERROR] 중복된 숫자가 있습니다.";
    private static final String ERROR_RANGEOVER = "[ERROR] 숫자는 1부터 45 사이의 숫자여야 합니다.";
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
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    // TODO: 추가 기능 구현
    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(ERROR_ISDUPLICATE);
            }
        }
    }

    public void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                throw new IllegalArgumentException(ERROR_RANGEOVER);
            }
        }
    }

    public int countMachedNumber(Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int count = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count ++;
            }
        }
        return count;
    }

    public boolean containBonusNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
