package lotto.domain;

import lotto.constants.LottoConstant;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE.getConstant()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
         return numbers.toString();
    }
}
