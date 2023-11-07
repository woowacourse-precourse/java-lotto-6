package lotto.domain;

import java.util.List;
import lotto.utils.Constants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateDistinctNumbers(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Constants.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < Constants.LOTTO_NUM_MIN || number > Constants.LOTTO_NUM_MAX)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
