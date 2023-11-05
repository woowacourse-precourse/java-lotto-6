package lotto.domain;

import java.util.List;
import lotto.domain.constant.LottoConstant;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_ITEM_COUNT.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}