package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.Constant;
import lotto.util.ErrorMessage;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_LOTTO_NUMBERS.getMessage());
        }
        validateDuplicate(numbers);
        validateValidRangeNumber(numbers);
    }

    // TODO: 추가 기능 구현

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateValidRangeNumber(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < Constant.LOTTO_NUMBER_MIN || number > Constant.LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        return checkNumbers.size() != numbers.size();
    }
}
