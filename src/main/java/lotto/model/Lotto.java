package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException(ErrorMessages
                        .OUT_OF_RANGE
                        .getMessage());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> checkDuplication = new HashSet<>(numbers);

        if (checkDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages
                    .DUPLICATE_NUMBER
                    .getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
