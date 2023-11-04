package lotto.domain;

import static lotto.domain.LottoRule.*;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
