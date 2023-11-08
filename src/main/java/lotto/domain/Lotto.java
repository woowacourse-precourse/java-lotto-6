package lotto.domain;

import java.util.List;
import lotto.constant.NumberStrategy;

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
        validateNumberCount(numbers);
        validateNumberDuplicate(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NumberStrategy.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NumberStrategy.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Lotto[" + numbers + ']';
    }

}
