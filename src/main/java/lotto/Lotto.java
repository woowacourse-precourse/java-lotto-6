package lotto;

import constants.Constants;
import exception.lottoException.DuplicateNumberException;
import exception.lottoException.InvalidLengthException;
import exception.lottoException.OutOfRangeException;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateNoDuplicates(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_LENGTH) {
            throw new InvalidLengthException();
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();
        if (distinctNumberCount != numbers.size()) {
            throw new DuplicateNumberException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.LOTTO_RANGE_START || number > Constants.LOTTO_RANGE_END) {
                throw new OutOfRangeException();
            }
        }
    }

    private void sort() {
        Collections.sort(numbers);
    }
}
