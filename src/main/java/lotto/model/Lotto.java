package lotto.model;

import java.util.List;
import lotto.util.ExceptionMessage;
import lotto.util.NumberConst;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberConst.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_PROPER_LOTTO_SIZE.getMessage());
        }
        if (!isUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED.getMessage());
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE.getMessage());
        }
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        long uniqueNumbersCount = numbers.stream()
                .distinct()
                .count();
        return uniqueNumbersCount == NumberConst.LOTTO_SIZE;
    }

    private static boolean isValidRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= NumberConst.MIN_RANGE && number <= NumberConst.MAX_RANGE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
