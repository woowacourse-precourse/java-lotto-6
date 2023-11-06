package lotto.domain;

import static java.util.Collections.sort;
import static lotto.utils.ErrorMessage.*;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isLottoSizeValid(numbers);
        isLottoNumberRangeValid(numbers);
    }

    private void isLottoNumberRangeValid(List<Integer> numbers) {
        if (numbers.get(numbers.size()-1) > 45 || numbers.get(0) < 1) {
            throw new IllegalArgumentException(IS_INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void isLottoSizeValid(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(IS_INVALID_LOTTO_SIZE.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
