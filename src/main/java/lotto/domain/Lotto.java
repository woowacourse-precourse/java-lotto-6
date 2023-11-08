package lotto.domain;

import java.util.*;

import static lotto.utils.Constants.*;

public class Lotto {
    private static final String DUPLICATE_NUMBER_ERROR = ERROR_PREFIX + "로또 숫자는 중복을 포함할 수 없습니다.";
    private static final String INVALID_NUMBER_COUNT_ERROR = ERROR_PREFIX + "로또 숫자 6개를 입력해 주십시오.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);

        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(INVALID_NUMBER_COUNT_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            System.out.println(DUPLICATE_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                System.out.println(INVALID_NUMBER_RANGE_ERROR);
                throw new IllegalArgumentException();
            }
        }
    }
}
