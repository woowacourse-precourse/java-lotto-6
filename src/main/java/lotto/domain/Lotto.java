package lotto.domain;

import static lotto.message.ErrorMessage.LOTTO_RANGE;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validationRange(numbers);
        this.numbers = ascendingNumbers(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validationRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> !(1 <= number && number <= 45))
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalStateException(LOTTO_RANGE.errorMessage());
                });
    }

    private List<Integer> ascendingNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
