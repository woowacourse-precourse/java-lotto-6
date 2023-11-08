package lotto.model.entity;

import java.util.List;
import lotto.utils.Constants;
import lotto.view.ExceptionMessage;

public class Lotto {

    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.CNT_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        long uniqueNumbersCount = numbers.stream().distinct().count();
        if (uniqueNumbersCount < numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
