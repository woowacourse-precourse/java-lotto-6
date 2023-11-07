package lotto;

import constants.Constants;
import exception.DuplicateLottoNumberException;
import exception.InvalidLottoLengthException;
import exception.OutOfLottoNumberRangeException;
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
            throw new InvalidLottoLengthException();
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();
        if (distinctNumberCount != numbers.size()) {
            throw new DuplicateLottoNumberException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.LOTTO_RANGE_START || number > Constants.LOTTO_RANGE_END) {
                throw new OutOfLottoNumberRangeException();
            }
        }
    }

    private void sort() {
        Collections.sort(numbers);
    }
}