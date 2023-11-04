package lotto;

import exception.LottoException;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUnique(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new LottoException(LottoException.ERROR_DUPLICATE_NUMBERS);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new LottoException(LottoException.ERROR_OUT_OF_RANGE_NUMBER);
            }
        }
    }

}
