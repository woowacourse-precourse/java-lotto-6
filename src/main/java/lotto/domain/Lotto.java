package lotto.domain;

import lotto.global.utils.constant.OutputType;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(OutputType.EXCEPTION_INPUT_LENGTH.getComment());
        }
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(OutputType.EXCEPTION_INPUT_REDUNDANT.getComment());
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(OutputType.EXCEPTION_INPUT_RANGE.getComment());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
