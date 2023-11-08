package lotto.domain;

import lotto.view.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.SIZE_OF_LOTTO_NUMBERS_LIST_MUST_BE_6.getMessage());
        }
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_CANNOT_BE_DUPLICATED.getMessage());
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
