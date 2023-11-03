package lotto.domain;

import lotto.exception.LottoNumberException;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberException.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
