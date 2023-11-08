package lotto.model;

import java.util.List;
import lotto.utils.constant.Condition;
import lotto.utils.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateOutOfSize(numbers);
        validateDuplication(numbers);
        validateOutOfRange(numbers);
    }

    private void validateOutOfSize(List<Integer> numbers) {
        if (numbers.size() != Condition.SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateOutOfRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Condition.MIN_RANGE.getNumber() || number > Condition.MAX_RANGE.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted(Integer::compareTo)
                .toList()
                .toString();
    }
}
