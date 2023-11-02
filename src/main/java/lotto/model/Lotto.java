package lotto.model;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoException.checkNumbersException(numbers);
        this.numbers = numbers;
    }
}
