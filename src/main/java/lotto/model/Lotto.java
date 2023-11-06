package lotto.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoException.NOT_SIX_NUMBERS.getExceptionMessage());
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
