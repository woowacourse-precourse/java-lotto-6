package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final LottoException lottoException = new LottoException();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        lottoException.validateLottoNumbers(numbers);
        }
    }

    // TODO: 추가 기능 구현
}
