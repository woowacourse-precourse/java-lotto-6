package lotto.domain;

import lotto.constant.Error;
import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private LottoException lottoException = LottoException.getLottoException();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            lottoException.InvalidCount();
        }
    }

    // TODO: 추가 기능 구현
}
