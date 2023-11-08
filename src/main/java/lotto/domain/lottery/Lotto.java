package lotto.domain.lottery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.constants.LottoConstraint.NUMBER_RANGE_MAXIMUM;
import static lotto.domain.constants.LottoConstraint.NUMBER_RANGE_MINIMUM;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < NUMBER_RANGE_MINIMUM.getValue() || number > NUMBER_RANGE_MAXIMUM.getValue()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
