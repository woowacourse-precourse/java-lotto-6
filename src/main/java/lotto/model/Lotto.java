package lotto.model;

import lotto.constants.Constants;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidLottoLengthException;
import lotto.exception.OutOfLottoNumberRangeException;
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

    public List<Integer> getNumbers() {
        return numbers;
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

    public void sort() {
        Collections.sort(this.numbers);
    }
}