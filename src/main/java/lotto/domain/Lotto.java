package lotto.domain;

import static lotto.constants.ExceptionMessage.IS_DUPLICATED;
import static lotto.constants.ExceptionMessage.IS_INSUFFICIENT;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        numbers.stream().sorted();
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(IS_INSUFFICIENT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(IS_DUPLICATED.getMessage());
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        long result = numbers.stream()
                .distinct().count();
        return result != numbers.size();
    }
}
