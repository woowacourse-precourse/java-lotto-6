package lotto.domain;

import static lotto.validation.constant.WinningNumbersInputConstant.DUPLICATE_MESSAGE;
import static lotto.validation.constant.WinningNumbersInputConstant.NUMBERS_COUNT_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_COUNT_MESSAGE.getMessage());
        }
    }

    public void validateNumberDuplication(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE.getMessage());
        }
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
