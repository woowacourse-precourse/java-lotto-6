package lotto.model;

import lotto.view.Messages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Messages.LOTTO_NUMBER_SIZE_ERROR_MESSAGE);
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(Messages.LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(Messages.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
            }
        }
    }

    // TODO: 추가 기능 구현
}
