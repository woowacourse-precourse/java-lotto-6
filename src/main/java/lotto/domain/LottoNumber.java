package lotto.domain;

import java.util.List;
import lotto.config.LottoGameRule;
import lotto.exception.LottoNumberOutOfRangeException;

public record LottoNumber(int number) {
    public LottoNumber {
        if (number < LottoGameRule.LOTTO_MIN_VALUE.value()
                || number > LottoGameRule.LOTTO_MAX_VALUE.value()) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    public boolean isMatched(final List<Integer> numbers) {
        return numbers.contains(number);
    }
}
