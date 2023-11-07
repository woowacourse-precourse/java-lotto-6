package lotto;

import static lotto.constant.message.Error.*;

import java.util.Collections;
import java.util.List;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
        this.numbers = sortNumbers(numbers);
    }

    protected void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_COUNT.getMessage());
        }
    }

    protected void validateDistinct(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
        }
    }

    protected void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    @Override
    public String toString() {
        return numbers.toString();
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
