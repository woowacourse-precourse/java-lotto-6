package lotto.model.domain;

import java.util.List;

import static lotto.constants.Error.DUPLICATE_INVALID;
import static lotto.constants.Error.SIZE_INVALID;
import static lotto.constants.Rule.LOTTO_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(SIZE_INVALID.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_INVALID.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
