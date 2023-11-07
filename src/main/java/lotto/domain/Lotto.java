package lotto.domain;

import java.util.List;
import lotto.domain.constant.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_ITEM_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}