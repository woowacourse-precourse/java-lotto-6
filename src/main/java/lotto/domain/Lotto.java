package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.OutOfNumberRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        checkLottoNumberDuplicatedAndThrowException(numbers);
        checkLottoNumberRangeAndThrowException(numbers);
    }

    private void checkLottoNumberDuplicatedAndThrowException(List<Integer> numbers)
            throws IllegalArgumentException {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new DuplicatedLottoNumberException();
        }
    }

    private void checkLottoNumberRangeAndThrowException(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (number > LottoProperty.LOTTO_NUMBER_MAX_RANGE.getNumber()
                    || number < LottoProperty.LOTTO_NUMBER_MIN_RANGE.getNumber()) {
                throw new OutOfNumberRangeException();
            }
        }
    }
}
