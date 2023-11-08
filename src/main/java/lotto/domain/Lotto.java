package lotto.domain;

import lotto.exception.ExceptionEnum;
import lotto.exception.LottoGameException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoGameException(ExceptionEnum.NOT_ENOUGH_NUMBER_EXCEPTION);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
