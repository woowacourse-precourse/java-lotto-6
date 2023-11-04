package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_NUMBER.getMessage());
        }
    }


}
