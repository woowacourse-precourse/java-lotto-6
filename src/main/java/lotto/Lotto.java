package lotto;

import static lotto.LottoConstants.LOTTO_NUMBERS;

import exception.LottoException;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS) {
            throw new IllegalArgumentException(LottoException.NOT_LOTTO_NUMBERS);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
