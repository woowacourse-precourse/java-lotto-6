package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String WRONG_SIZE_ERROR = "[ERROR] 로또 번호는 6자리의 숫자여야 합니다.";
    private static final String DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복된 번호를 포함하지 않습니다.";
    private static final String WRONG_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
        validateMinToMax(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WRONG_SIZE_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private void validateMinToMax(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(WRONG_RANGE_ERROR);
            }
        }
    }
}
